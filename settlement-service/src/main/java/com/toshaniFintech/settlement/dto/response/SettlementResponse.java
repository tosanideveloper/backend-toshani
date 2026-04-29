package com.toshaniFintech.settlement.dto.response;

import com.toshaniFintech.settlement.enums.SettlementRefType;
import com.toshaniFintech.settlement.enums.SettlementStatus;
import com.toshaniFintech.settlement.enums.SettlementTransactionType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class SettlementResponse {

    private String id;
    private String settlementUuid;
    private String transactionId;
    private String userUuid;
    private String rrnBank;
    private String clientRefId;
    private BigDecimal transactionAmount;
    private SettlementStatus status;
    private SettlementRefType transactionRefType;
    private SettlementTransactionType transactionType;
    private String merchantUuid;
    private String userAccountUuid;
    private LocalDate settlementDate;
    private boolean active;
}