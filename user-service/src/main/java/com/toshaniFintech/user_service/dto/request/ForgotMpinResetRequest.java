package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ForgotMpinResetRequest {

    @NotBlank(message = "OTP is required")
    @Pattern(regexp = "^[0-9]{6}$", message = "OTP must be 6 digits")
    private String otp;

    @NotBlank(message = "New MPIN is required")
    @Pattern(regexp = "^[0-9]{4}$", message = "MPIN must be 4 digits")
    private String newMpin;

    @NotBlank(message = "Confirm MPIN is required")
    @Pattern(regexp = "^[0-9]{4}$", message = "Confirm MPIN must be 4 digits")
    private String confirmMpin;
}
