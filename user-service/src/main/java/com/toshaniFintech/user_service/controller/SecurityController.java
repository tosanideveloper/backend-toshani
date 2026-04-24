package com.toshaniFintech.user_service.controller;

import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.*;
import com.toshaniFintech.user_service.dto.response.AuthenticatorSetupResponse;
import com.toshaniFintech.user_service.dto.response.SecurityStatusResponse;
import com.toshaniFintech.user_service.service.SecurityService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/security")
@Tag(name = "Security API", description = "APIs for MPIN and Google Authenticator")
public class SecurityController {

    @Autowired
    private SecurityService securityService;

    @PostMapping("/mpin/set")
    public ResponseEntity<APIResponse<Object>> setMpin(@Valid @RequestBody MpinSetRequest request,
                                                       Authentication authentication) {
        securityService.setMpin(authentication.getName(), request);
        return ResponseUtil.success(
                "MPIN set successfully",
                null,
                HttpStatus.OK
        );
    }

    @PostMapping("/mpin/verify")
    public ResponseEntity<APIResponse<Object>> verifyMpin(@Valid @RequestBody MpinVerifyRequest request,
                                                          Authentication authentication) {
        securityService.verifyMpin(authentication.getName(), request);
        return ResponseUtil.success(
                "MPIN verified successfully",
                null,
                HttpStatus.OK
        );
    }

    @PutMapping("/mpin/change")
    public ResponseEntity<APIResponse<Object>> changeMpin(@Valid @RequestBody ChangeMpinRequest request,
                                                          Authentication authentication) {
        securityService.changeMpin(authentication.getName(), request);
        return ResponseUtil.success(
                "MPIN changed successfully",
                null,
                HttpStatus.OK
        );
    }

    @PutMapping("/mpin/disable")
    public ResponseEntity<APIResponse<Object>> disableMpin(@Valid @RequestBody MpinVerifyRequest request,
                                                           Authentication authentication) {
        securityService.disableMpin(authentication.getName(), request);
        return ResponseUtil.success(
                "MPIN disabled successfully",
                null,
                HttpStatus.OK
        );
    }

    @GetMapping("/mpin/status")
    public ResponseEntity<APIResponse<SecurityStatusResponse>> getMpinStatus(Authentication authentication) {
        return ResponseUtil.success(
                "MPIN status fetched successfully",
                securityService.getMpinStatus(authentication.getName()),
                HttpStatus.OK
        );
    }

    @PostMapping("/mpin/forgot/initiate")
    public ResponseEntity<APIResponse<Object>> initiateForgotMpin(
            @Valid @RequestBody ForgotMpinInitiateRequest request,
            Authentication authentication) {

        securityService.initiateForgotMpin(authentication.getName(), request);
        return ResponseUtil.success(
                "Forgot MPIN OTP sent successfully",
                null,
                HttpStatus.OK
        );
    }

    @PostMapping("/mpin/forgot/reset")
    public ResponseEntity<APIResponse<Object>> resetForgotMpin(
            @Valid @RequestBody ForgotMpinResetRequest request,
            Authentication authentication) {

        securityService.resetForgotMpin(authentication.getName(), request);
        return ResponseUtil.success(
                "MPIN reset successfully",
                null,
                HttpStatus.OK
        );
    }

    @GetMapping("/authenticator/status")
    public ResponseEntity<APIResponse<SecurityStatusResponse>> getAuthenticatorStatus(Authentication authentication) {
        return ResponseUtil.success(
                "Authenticator status fetched successfully",
                securityService.getAuthenticatorStatus(authentication.getName()),
                HttpStatus.OK
        );
    }

    @PostMapping("/authenticator/setup")
    public ResponseEntity<APIResponse<AuthenticatorSetupResponse>> setupAuthenticator(Authentication authentication) {
        return ResponseUtil.success(
                "Authenticator setup generated successfully",
                securityService.setupAuthenticator(authentication.getName()),
                HttpStatus.OK
        );
    }

    @PostMapping("/authenticator/verify")
    public ResponseEntity<APIResponse<Object>> verifyAuthenticator(@Valid @RequestBody OtpVerifyRequest request,
                                                                   Authentication authentication) {
        securityService.verifyAuthenticator(authentication.getName(), request);
        return ResponseUtil.success(
                "Google Authenticator enabled successfully",
                null,
                HttpStatus.OK
        );
    }

    @PutMapping("/authenticator/disable")
    public ResponseEntity<APIResponse<Object>> disableAuthenticator(@Valid @RequestBody OtpVerifyRequest request,
                                                                    Authentication authentication) {
        securityService.disableAuthenticator(authentication.getName(), request);
        return ResponseUtil.success(
                "Google Authenticator disabled successfully",
                null,
                HttpStatus.OK
        );
    }
    @PostMapping("/authenticator/reset/initiate")
    public ResponseEntity<APIResponse<Object>> initiateAuthenticatorReset(
            Authentication authentication) {

        securityService.initiateAuthenticatorReset(authentication.getName());
        return ResponseUtil.success(
                "Authenticator reset OTP sent successfully",
                null,
                HttpStatus.OK
        );
    }

    @PostMapping("/authenticator/reset/confirm")
    public ResponseEntity<APIResponse<Object>> confirmAuthenticatorReset(
            @Valid @RequestBody AuthenticatorResetConfirmRequest request,
            Authentication authentication) {

        securityService.confirmAuthenticatorReset(authentication.getName(), request);
        return ResponseUtil.success(
                "Authenticator reset successfully",
                null,
                HttpStatus.OK
        );
    }
}