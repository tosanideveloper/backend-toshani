package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PayoutChargeCommissionRequest {
    @NotNull(message = "Min amount is required")
    @DecimalMin(value = "0.0", inclusive = true, message = "Min amount must be greater than or equal to 0")
    private Double minAmount;

    @NotNull(message = "Max amount is required")
    @DecimalMin(value = "0.0", inclusive = true, message = "Max amount must be greater than or equal to 0")
    private Double maxAmount;

    @NotBlank(message = "Transaction type is required")
    private String txnType;

    @NotBlank(message = "Charge type is required")
    private String chargeType;

    @NotNull(message = "Charge is required")
    @DecimalMin(value = "0.0", inclusive = true, message = "Charge must be greater than or equal to 0")
    private Double charge;
}
