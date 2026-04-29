package com.toshaniFintech.settlement.dto.response;

import com.toshaniFintech.settlement.enums.BankSettlementStatus;
import com.toshaniFintech.settlement.enums.WalletTransactionRefType;
import com.toshaniFintech.settlement.enums.WalletTransactionType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class WalletTransactionResponse {

    private String id;
    private String walletUuid;
    private String userUuid;
    private BigDecimal transactionAmount;
    private String walletTransactionId;
    private WalletTransactionType transactionType;
    private String transactionRefId;
    private WalletTransactionRefType transactionRefType;
    private String status;
    private BigDecimal settlementAmount;
    private BankSettlementStatus bankSettlementStatus;
    private Boolean realtimeSettlement;
    private LocalDate transactionDate;
    private LocalDate eligibleSettlementDate;
    private LocalDate eligibleSettlementDateUpdated;
    private BigDecimal gst;
    private BigDecimal cgst;
    private BigDecimal sgst;
    private BigDecimal tds;
}