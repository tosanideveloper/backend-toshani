package com.toshaniFintech.settlement.dto.request;

import com.toshaniFintech.settlement.enums.SettlementRefType;
import com.toshaniFintech.settlement.enums.SettlementTransactionType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class CreateSettlementRequest {

    @NotBlank(message = "User UUID is mandatory")
    private String userUuid;

    @NotNull(message = "Transaction amount is mandatory")
    @DecimalMin(value = "0.01", message = "Amount must be greater than 0")
    private BigDecimal transactionAmount;

    // Optional: links settlement to a specific originating transaction
    private String transactionId;

    private String clientRefId;

    @NotNull(message = "Transaction ref type is mandatory")
    private SettlementRefType transactionRefType;

    @NotNull(message = "Transaction type is mandatory")
    private SettlementTransactionType transactionType;

    @NotBlank(message = "Merchant UUID is mandatory")
    private String merchantUuid;

    @NotBlank(message = "User account UUID is mandatory")
    private String userAccountUuid;

    @NotNull(message = "Settlement date is mandatory")
    private LocalDate settlementDate;
}