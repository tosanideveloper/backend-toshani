package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class FundRequestRequest {
    @NotBlank(message = "Request id is required")
    @Size(max = 50, message = " Request id must not exceed 50 characters")
    private String requestId;

    @NotBlank(message = "Partner id is required")
    @Size(max = 50, message = "Partner id must not exceed 50 characters")
    private String partnerId;

    @NotBlank(message = "Company name is required")
    @Size(max = 50, message = "Company name must not exceed 50 characters")
    private String companyName;

    @NotBlank(message = "Bank name is required")
    @Size(max = 50, message = "Bank name must not exceed 50 characters")
    private String bankName;

    @NotBlank(message = "Account no is required")
    @Size(max = 20, message = " Account no must not exceed 20 characters")
    private String accountNo;

    @NotBlank(message = "IFSC code is required")
    @Size(max = 20, message = "IFSC code must not exceed 20 characters")
    private String ifscCode;

    private String image;


}
