package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthenticatorResetConfirmRequest {
    @NotBlank(message = "OTP is required")
    private String otp;
}
