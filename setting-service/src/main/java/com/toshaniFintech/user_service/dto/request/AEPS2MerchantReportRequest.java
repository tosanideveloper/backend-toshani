package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AEPS2MerchantReportRequest {
    @NotBlank(message = "Date is required")
    @Size(max = 10, message = "date must not exceed 10 characters")
    private String date;

    @NotBlank(message = "Partner details is required")
    @Size(max = 100, message = " partner Details must not exceed 100 characters")
    private String partnerDetails;

    @NotBlank(message = "Username is required")
    @Size(max = 50, message = "user Name must not exceed 50 characters")
    private String username;

    @NotBlank(message = "Merchant name is required")
    @Size(max = 50, message = "merchant Name must not exceed 50 characters")
    private String merchantName;

}

