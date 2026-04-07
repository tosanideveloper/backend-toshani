package com.toshaniFintech.user_service.controller;

import java.util.List;

import com.toshaniFintech.user_service.dto.request.ForgotPasswordRequest;
import com.toshaniFintech.user_service.dto.request.ResetPasswordRequest;
import com.toshaniFintech.user_service.dto.request.UsersRequest;
import com.toshaniFintech.common.dto.response.UsersResponse;
import com.toshaniFintech.user_service.service.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/create")
    public ResponseEntity<UsersResponse> createUser(@Valid @RequestBody UsersRequest request) {
        UsersResponse response = usersService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UsersResponse>> getAllUsersForSuperAdmin() {
        List<UsersResponse> response = usersService.getAllUsersForSuperAdmin();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@Valid @RequestBody ForgotPasswordRequest request) {
        usersService.forgotPassword(request);
        return ResponseEntity.ok("Password reset link/token generated successfully");
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@Valid @RequestBody ResetPasswordRequest request) {
        usersService.resetPassword(request);
        return ResponseEntity.ok("Password reset successfully");
    }
}