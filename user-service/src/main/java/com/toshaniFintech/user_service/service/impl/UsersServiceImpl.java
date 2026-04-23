package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.dto.response.UsersResponse;
import com.toshaniFintech.common.entity.PasswordResetToken;
import com.toshaniFintech.common.entity.Role;
import com.toshaniFintech.common.entity.Users;
import com.toshaniFintech.common.exception.model.BadRequestException;
import com.toshaniFintech.common.exception.model.NotFoundException;
import com.toshaniFintech.common.exception.model.UnprocessableEntityException;
import com.toshaniFintech.common.repository.UsersRepository;
import com.toshaniFintech.user_service.client.NotificationClient;
import com.toshaniFintech.user_service.dto.request.*;
import com.toshaniFintech.user_service.repository.PasswordResetTokenRepository;
import com.toshaniFintech.user_service.repository.RoleRepository;
import com.toshaniFintech.user_service.service.UsersService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Slf4j
@Service("usersService")
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private NotificationClient notificationClient;

    @Override
    public UsersResponse createUser(UsersRequest request) {
        validateCreateUserRequest(request);

        Set<Role> roles = getRolesFromRequest(request.getRoles());

        Users user = buildUserEntity(request, roles);
        Users savedUser = usersRepository.save(user);

        log.info("User created successfully with id: {}", savedUser.getId());
        return mapToResponse(savedUser);
    }

    @Override
    @Transactional
    public List<UsersResponse> getAllUsersForSuperAdmin() {
        log.info("Fetching all users");

        List<Users> users = usersRepository.findAll();

        return users.stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    @Transactional
    public void forgotPassword(ForgotPasswordRequest request) {
        Users user = usersRepository.findByEmailIgnoreCase(request.getEmail())
                .orElseThrow(() -> new NotFoundException("User not found with this email"));

        String tokenValue = UUID.randomUUID().toString();

        PasswordResetToken token = passwordResetTokenRepository.findTokenByUserId(user.getId())
                .orElse(null);

        if (token == null) {
            token = new PasswordResetToken();
            token.setUser(user);
        }

        token.setToken(tokenValue);
        token.setUsed(false);
        token.setExpiryDate(LocalDateTime.now().plusMinutes(30));

        passwordResetTokenRepository.saveAndFlush(token);

        ResetPasswordMailRequest mailRequest = new ResetPasswordMailRequest();
        mailRequest.setToEmail(user.getEmail());
        mailRequest.setUserName(user.getUserName());
        mailRequest.setToken(tokenValue);

        try {
            log.info("Calling notification-service for forgot password mail");
            notificationClient.sendResetPasswordMail(mailRequest);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        log.info("Password reset token generated and email sent for email: {}", request.getEmail());
    }

    @Override
    @Transactional
    public void resetPassword(ResetPasswordRequest request) {
        PasswordResetToken resetToken = passwordResetTokenRepository.findByToken(request.getToken())
                .orElseThrow(() -> new BadRequestException("Invalid token"));

        if (resetToken.isUsed()) {
            throw new BadRequestException("Token already used");
        }

        if (resetToken.getExpiryDate().isBefore(LocalDateTime.now())) {
            throw new BadRequestException("Token expired");
        }

        Users user = resetToken.getUser();
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        usersRepository.save(user);

        resetToken.setUsed(true);
        passwordResetTokenRepository.save(resetToken);

        passwordResetTokenRepository.delete(resetToken);

        PasswordResetSuccessMailRequest mailRequest = new PasswordResetSuccessMailRequest();
        mailRequest.setToEmail(user.getEmail());
        mailRequest.setUserName(user.getUserName());

        try {
            notificationClient.sendPasswordResetSuccessMail(mailRequest);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        log.info("Password reset successful for user: {}", user.getEmail());
    }

    private void validateCreateUserRequest(UsersRequest request) {
        if (usersRepository.existsByUserNameIgnoreCase(request.getUserName())) {
            throw new UnprocessableEntityException("Username already exists");
        }

        if (usersRepository.existsByEmailIgnoreCase(request.getEmail())) {
            throw new UnprocessableEntityException("Email already exists");
        }
    }

    private Set<Role> getRolesFromRequest(List<String> roleNames) {
        Set<Role> roles = new HashSet<>();

        for (String roleName : roleNames) {
            Role role = roleRepository.findByNameIgnoreCase(roleName)
                    .orElseThrow(() -> new NotFoundException("Role not found: " + roleName));
            roles.add(role);
        }

        return roles;
    }

    private Users buildUserEntity(UsersRequest request, Set<Role> roles) {
        Users user = new Users();
        user.setUserName(request.getUserName());
        user.setEmail(request.getEmail());
        user.setMobile(request.getMobile());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setActive(true);
        user.setRoles(roles);
        return user;
    }

    private UsersResponse mapToResponse(Users user) {
        UsersResponse response = new UsersResponse();
        response.setId(user.getId());
        response.setUsername(user.getUserName());
        response.setEmail(user.getEmail());
        response.setMobile(user.getMobile());
        response.setActive(user.isActive());
        response.setRoles(
                user.getRoles().stream()
                        .map(Role::getName)
                        .toList()
        );
        return response;
    }
}