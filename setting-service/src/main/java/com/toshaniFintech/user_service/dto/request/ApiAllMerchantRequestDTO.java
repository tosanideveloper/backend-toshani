package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data

public class ApiAllMerchantRequestDTO {
    @NotBlank(message = "Merchant details must not be blank")
    private String merchant;
    @NotBlank(message = "Mobile Number must not be blank")
    private String mobile;
    @NotBlank(message = "Email address must not be blank")
    private String email;

    private String isPanVerified;
    private String isAadhaarCardVerified;
    private String isAadhaarNoVerified;

    @NotBlank(message = "Status must not be blank")
    private String status;
}
