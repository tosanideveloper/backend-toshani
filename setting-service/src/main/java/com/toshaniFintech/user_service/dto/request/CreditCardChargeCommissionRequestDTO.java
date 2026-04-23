package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreditCardChargeCommissionRequestDTO {

    @NotNull(message = "Min amount is required")
    private Double minAmount;

    @NotNull(message = "Max amount is required")
    private Double maxAmount;

    @NotNull(message = "Charge type is required")
    private String chargeType; // Fixed / Percent

    @NotNull(message = "Charge is required")
    private Double charge;
}