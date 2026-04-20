package com.toshaniFintech.notification.controller;

import com.toshaniFintech.notification.dto.request.PasswordResetSuccessMailRequest;
import com.toshaniFintech.notification.dto.request.ResetPasswordMailRequest;
import com.toshaniFintech.notification.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notifications/email")
@RequiredArgsConstructor
public class NotificationController {

    private final EmailService emailService;

    @PostMapping("/reset-password")
    public ResponseEntity<Boolean> sendResetPasswordMail(@RequestBody ResetPasswordMailRequest request) throws Exception {
        System.out.println("NOTIFICATION RESET PASSWORD API HIT");
        return ResponseEntity.ok(
                emailService.sendResetPasswordMail(
                        request.getToEmail(),
                        request.getUserName(),
                        request.getToken()
                )
        );
    }

    @PostMapping("/reset-success")
    public ResponseEntity<Boolean> sendPasswordResetSuccessMail(@RequestBody PasswordResetSuccessMailRequest request) throws Exception {
        return ResponseEntity.ok(
                emailService.sendPasswordResetSuccessMail(
                        request.getToEmail(),
                        request.getUserName()
                )
        );
    }
}