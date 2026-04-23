package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class RemittanceChargeCommissionRequest {
    @NotNull(message = "Min amount is required")
    @DecimalMin(value = "0.0", inclusive = true, message = "Min amount must be >= 0")
    private BigDecimal minAmount;

    @NotNull(message = "Max amount is required")
    @DecimalMin(value = "0.0", inclusive = true, message = "Max amount must be >= 0")
    private BigDecimal maxAmount;

    @NotBlank(message = "Charge type is required")
    private String chargeType;

    @NotNull(message = "Charge is required")
    @DecimalMin(value = "0.0", inclusive = true, message = "Charge must be >= 0")
    private BigDecimal charge;

}
