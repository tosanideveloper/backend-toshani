package com.toshaniFintech.notification.dto.request;

import lombok.Data;

@Data
public class PasswordResetSuccessMailRequest {
    private String toEmail;
    private String userName;
}