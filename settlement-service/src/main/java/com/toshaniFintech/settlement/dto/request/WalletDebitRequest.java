package com.toshaniFintech.settlement.dto.request;

import com.toshaniFintech.settlement.enums.WalletTransactionRefType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class WalletDebitRequest {

    @NotBlank(message = "User UUID is mandatory")
    private String userUuid;

    @NotNull(message = "Transaction amount is mandatory")
    @DecimalMin(value = "0.01", message = "Amount must be greater than 0")
    private BigDecimal transactionAmount;

    @NotNull(message = "Transaction ref type is mandatory")
    private WalletTransactionRefType transactionRefType;

    private String transactionRefId;

    @NotNull(message = "Transaction date is mandatory")
    private LocalDate transactionDate;
}