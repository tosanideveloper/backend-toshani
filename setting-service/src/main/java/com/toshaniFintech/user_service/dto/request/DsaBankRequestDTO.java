package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DsaBankRequestDTO {
    @NotBlank(message = "Dsa Bank details must not be blank")
    private String dsaBankName;

    @NotBlank(message = "Display name must not be blank")
    private String displayName;

    @NotBlank(message = "Account Name must not be blank")
    private String accountName;

    @NotBlank(message = "Account Number must not be blank")
    @Size(max = 20, message = "Account Number must not exceed 20 characters")
    private String accountNumber;

    @NotBlank(message = "IFSC Code must not be blank")
    @Size(max = 11, message = "IFSC Code must not exceed 11 characters")
    private String ifscCode;
}
