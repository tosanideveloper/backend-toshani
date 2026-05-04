package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AdminEmailRequestDTO {
    @NotBlank(message = "emailName must not be blank")
    @Size(max = 100, message = "emailName must not exceed 100 characters")
    private String emailName;

    @NotBlank(message = "emailAddress must not be blank")
    @Email(message = "emailAddress must be a valid email")
    @Size(max = 150, message = "emailAddress must not exceed 150 characters")
    private String emailAddress;

    @NotBlank(message = "emailType must not be blank")
    @Size(max = 50, message = "emailType must not exceed 50 characters")
    private String emailType;

    @NotBlank(message = "status must not be blank")
    @Size(max = 20, message = "status must not exceed 20 characters")
    private String status;
}
