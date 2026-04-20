package com.toshaniFintech.user_service.dto.request;

import lombok.Data;

@Data
public class ResetPasswordMailRequest {
    private String toEmail;
    private String userName;
    private String token;
}
