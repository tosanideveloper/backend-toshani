package com.toshaniFintech.settlement.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class WalletBalanceHistoryResponse {

    private String id;
    private String uuid;
    private String userUuid;
    private LocalDate date;
    private BigDecimal bodBalance;
    private BigDecimal eodBalance;
    private BigDecimal totalDebitAmount;
    private BigDecimal totalCreditAmount;
    private BigDecimal eligibleBod;
    private BigDecimal eligibleEod;
}