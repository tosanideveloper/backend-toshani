package com.toshaniFintech.user_service.dto.request;

import lombok.Data;

@Data
public class PasswordResetSuccessMailRequest {
    private String toEmail;
    private String userName;
}