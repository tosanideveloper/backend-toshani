package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ForgotMpinInitiateRequest {

    @NotBlank(message = "Validation type is required")
    private String validationType; // EMAIL / MOBILE
}