package com.toshaniFintech.settlement.dto.request;

import com.toshaniFintech.settlement.enums.WalletTransactionRefType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class WalletCreditRequest {

    @NotBlank(message = "User UUID is mandatory")
    private String userUuid;

    @NotNull(message = "Transaction amount is mandatory")
    @DecimalMin(value = "0.01", message = "Amount must be greater than 0")
    private BigDecimal transactionAmount;

    // Net amount after deductions, used to compute eligible cashout balance
    @NotNull(message = "Settlement amount is mandatory")
    @DecimalMin(value = "0.0", inclusive = true, message = "Settlement amount cannot be negative")
    private BigDecimal settlementAmount;

    @NotNull(message = "Transaction ref type is mandatory")
    private WalletTransactionRefType transactionRefType;

    // The ID of the source transaction (e.g., AEPS txn ID)
    private String transactionRefId;

    @NotNull(message = "Transaction date is mandatory")
    private LocalDate transactionDate;

    // Derived from product settlement_day; set by caller at write time
    @NotNull(message = "Eligible settlement date is mandatory")
    private LocalDate eligibleSettlementDate;

    // true = T+0 (realtime), false = T+N
    @NotNull(message = "Realtime settlement flag is mandatory")
    private Boolean realtimeSettlement;

    private BigDecimal gst;
    private BigDecimal cgst;
    private BigDecimal sgst;
    private BigDecimal tds;
}