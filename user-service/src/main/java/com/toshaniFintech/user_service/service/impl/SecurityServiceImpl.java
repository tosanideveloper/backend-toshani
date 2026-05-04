package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.entity.Users;
import com.toshaniFintech.common.exception.model.BadRequestException;
import com.toshaniFintech.common.exception.model.NotFoundException;
import com.toshaniFintech.common.repository.UsersRepository;
import com.toshaniFintech.user_service.dto.request.*;
import com.toshaniFintech.user_service.dto.response.AuthenticatorSetupResponse;
import com.toshaniFintech.user_service.dto.response.SecurityStatusResponse;
import com.toshaniFintech.user_service.entity.UserSecurity;
import com.toshaniFintech.user_service.repository.UserSecurityRepository;
import com.toshaniFintech.user_service.service.SecurityService;
import com.toshaniFintech.user_service.util.TotpUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private UserSecurityRepository userSecurityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TotpUtility totpUtility;

    private UserSecurity getUserSecurity(String username) {
        Users user = userRepository.findByUserName(username)
                .orElseThrow(() -> new NotFoundException("User not found"));

        return userSecurityRepository.findByUserId(user.getId())
                .orElseGet(() -> {
                    UserSecurity security = new UserSecurity();
                    security.setUserId(user.getId());
                    security.setMpinEnabled(false);
                    security.setGoogleAuthEnabled(false);
                    return userSecurityRepository.save(security);
                });
    }

    @Override
    public void setMpin(String username, MpinSetRequest request) {
        if (!request.getMpin().equals(request.getConfirmMpin())) {
            throw new BadRequestException("MPIN and Confirm MPIN do not match");
        }

        UserSecurity security = getUserSecurity(username);
        security.setMpinHash(passwordEncoder.encode(request.getMpin()));
        security.setMpinEnabled(true);

        userSecurityRepository.save(security);
    }

    @Override
    public void verifyMpin(String username, MpinVerifyRequest request) {
        UserSecurity security = getUserSecurity(username);

        if (security.getMpinHash() == null || !Boolean.TRUE.equals(security.getMpinEnabled())) {
            throw new BadRequestException("MPIN is not enabled");
        }
        if (!passwordEncoder.matches(request.getMpin(), security.getMpinHash())) {
            throw new BadRequestException("Invalid MPIN");
        }
    }

    @Override
    public void changeMpin(String username, ChangeMpinRequest request) {
        if (!request.getNewMpin().equals(request.getConfirmMpin())) {
            throw new BadRequestException("New MPIN and Confirm MPIN do not match");
        }

        UserSecurity security = getUserSecurity(username);

        if (security.getMpinHash() == null || !Boolean.TRUE.equals(security.getMpinEnabled())) {
            throw new BadRequestException("MPIN is not enabled");
        }

        if (!passwordEncoder.matches(request.getOldMpin(), security.getMpinHash())) {
            throw new BadRequestException("Old MPIN is incorrect");
        }

        security.setMpinHash(passwordEncoder.encode(request.getNewMpin()));
        security.setMpinEnabled(true);

        userSecurityRepository.save(security);
    }

    @Override
    public void disableMpin(String username, MpinVerifyRequest request) {
        UserSecurity security = getUserSecurity(username);

        if (security.getMpinHash() == null || !Boolean.TRUE.equals(security.getMpinEnabled())) {
            throw new BadRequestException("MPIN is not enabled");
        }

        if (!passwordEncoder.matches(request.getMpin(), security.getMpinHash())) {
            throw new BadRequestException("Invalid MPIN");
        }

        security.setMpinHash(null);
        security.setMpinEnabled(false);

        userSecurityRepository.save(security);
    }

    @Override
    public SecurityStatusResponse getMpinStatus(String username) {
        UserSecurity security = getUserSecurity(username);
        boolean mPinEnabled = Boolean.TRUE.equals(security.getMpinEnabled());
        boolean authEnabled = Boolean.TRUE.equals(security.getGoogleAuthEnabled());
        return SecurityStatusResponse.builder()
                .mpinEnabled(Boolean.TRUE.equals(security.getMpinEnabled()))
                .mPinStatus(mPinEnabled ? "enabled":"disabled")
                .authenticatorEnabled(authEnabled)
                .authenticationCurrentStatus(authEnabled ? "enabled":"disabled")
                .build();
    }

    @Override
    public void initiateForgotMpin(String username, ForgotMpinInitiateRequest request) {
        Users user = userRepository.findByUserName(username)
                .orElseThrow(() -> new NotFoundException("User not found"));

        UserSecurity security = getUserSecurity(username);

        if (security.getMpinHash() == null || !Boolean.TRUE.equals(security.getMpinEnabled())) {
            throw new BadRequestException("MPIN is not enabled");
        }

        String otp = generateOtp();
        LocalDateTime expiryTime = LocalDateTime.now().plusMinutes(5);

        security.setForgotMpinOtp(otp);
        security.setForgotMpinOtpExpiry(expiryTime);

        userSecurityRepository.save(security);

        // TODO: send OTP to email / SMS
        // Example:
        // emailService.sendEmail(user.getEmail(), "Forgot MPIN OTP", "Your OTP is: " + otp);

        System.out.println("Forgot MPIN OTP for " + user.getEmail() + " is: " + otp);
    }

    @Override
    public void resetForgotMpin(String username, ForgotMpinResetRequest request) {
        if (!request.getNewMpin().equals(request.getConfirmMpin())) {
            throw new BadRequestException("New MPIN and Confirm MPIN do not match");
        }

        UserSecurity security = getUserSecurity(username);

        if (security.getForgotMpinOtp() == null || security.getForgotMpinOtpExpiry() == null) {
            throw new BadRequestException("Forgot MPIN OTP not initiated");
        }

        if (LocalDateTime.now().isAfter(security.getForgotMpinOtpExpiry())) {
            throw new BadRequestException("OTP has expired");
        }

        if (!security.getForgotMpinOtp().equals(request.getOtp())) {
            throw new BadRequestException("Invalid OTP");
        }

        security.setMpinHash(passwordEncoder.encode(request.getNewMpin()));
        security.setMpinEnabled(true);

        security.setForgotMpinOtp(null);
        security.setForgotMpinOtpExpiry(null);

        userSecurityRepository.save(security);
    }


    @Override
    public SecurityStatusResponse getAuthenticatorStatus(String username) {
        UserSecurity security = getUserSecurity(username);
        boolean mPinEnabled = Boolean.TRUE.equals(security.getMpinEnabled());
        boolean authEnabled = Boolean.TRUE.equals(security.getGoogleAuthEnabled());
        return SecurityStatusResponse.builder()
                .authenticatorEnabled(authEnabled)
                .authenticationCurrentStatus(authEnabled ? "enabled" : "disabled")
                .mpinEnabled(mPinEnabled)
                .mPinStatus(mPinEnabled ? "enabled" : "disabled")
                .build();
    }

    @Override
    public AuthenticatorSetupResponse setupAuthenticator(String username) {
        Users user = userRepository.findByUserName(username)
                .orElseThrow(() -> new NotFoundException("User not found"));

        UserSecurity security = getUserSecurity(username);

        String secret = totpUtility.generateSecret();
        String otpauthUrl = totpUtility.buildOtpAuthUrl(user.getEmail(), secret);
        String qrCodeBase64 = totpUtility.generateQrCodeBase64(otpauthUrl);

        security.setGoogleAuthSecret(secret);
        security.setGoogleAuthEnabled(false);

        userSecurityRepository.save(security);

        return AuthenticatorSetupResponse.builder()
                .secret(secret)
                .otpauthUrl(otpauthUrl)
                .qrCodeBase64(qrCodeBase64)
                .build();
    }

    @Override
    public void verifyAuthenticator(String username, OtpVerifyRequest request) {
        UserSecurity security = getUserSecurity(username);

        if (security.getGoogleAuthSecret() == null) {
            throw new BadRequestException("Authenticator setup not initiated");
        }

        boolean valid = totpUtility.verifyCode(security.getGoogleAuthSecret(), request.getOtp());
        if (!valid) {
            throw new BadRequestException("Invalid OTP");
        }

        security.setGoogleAuthEnabled(true);
        userSecurityRepository.save(security);
    }

    @Override
    public void disableAuthenticator(String username, OtpVerifyRequest request) {
        UserSecurity security = getUserSecurity(username);

        if (security.getGoogleAuthSecret() == null || !Boolean.TRUE.equals(security.getGoogleAuthEnabled())) {
            throw new BadRequestException("Authenticator is not enabled");
        }

        boolean valid = totpUtility.verifyCode(security.getGoogleAuthSecret(), request.getOtp());

        if (!valid) {
            throw new BadRequestException("Invalid OTP");
        }

        security.setGoogleAuthEnabled(false);
        security.setGoogleAuthSecret(null);

        userSecurityRepository.save(security);
    }

    @Override
    public void initiateAuthenticatorReset(String username) {
        Users user = userRepository.findByUserName(username)
                .orElseThrow(() -> new NotFoundException("User not found"));

        UserSecurity security = getUserSecurity(username);

        if (security.getGoogleAuthSecret() == null || !Boolean.TRUE.equals(security.getGoogleAuthEnabled())) {
            throw new BadRequestException("Authenticator is not enabled");
        }

        String otp = generateOtp();
        LocalDateTime expiryTime = LocalDateTime.now().plusMinutes(5);

        security.setAuthenticatorResetOtp(otp);
        security.setAuthenticatorResetOtpExpiry(expiryTime);

        userSecurityRepository.save(security);

        // TODO send OTP via email/SMS
        System.out.println("Authenticator reset OTP for " + user.getEmail() + " is: " + otp);
    }

    @Override
    public void confirmAuthenticatorReset(String username, AuthenticatorResetConfirmRequest request) {
        UserSecurity security = getUserSecurity(username);

        if (security.getAuthenticatorResetOtp() == null || security.getAuthenticatorResetOtpExpiry() == null) {
            throw new BadRequestException("Authenticator reset not initiated");
        }

        if (LocalDateTime.now().isAfter(security.getAuthenticatorResetOtpExpiry())) {
            throw new BadRequestException("OTP has expired");
        }

        if (!security.getAuthenticatorResetOtp().equals(request.getOtp())) {
            throw new BadRequestException("Invalid OTP");
        }

        security.setGoogleAuthEnabled(false);
        security.setGoogleAuthSecret(null);
        security.setAuthenticatorResetOtp(null);
        security.setAuthenticatorResetOtpExpiry(null);

        userSecurityRepository.save(security);
    }

    private String generateOtp() {
        int otp = 100000 + new Random().nextInt(900000);
        return String.valueOf(otp);
    }
}