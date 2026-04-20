package com.toshaniFintech.user_service.service;

public interface EmailService {
    void sendResetPasswordMail(String toEmail, String userName, String token);

    void sendPasswordResetSuccessMail(String toEmail, String userName);
}