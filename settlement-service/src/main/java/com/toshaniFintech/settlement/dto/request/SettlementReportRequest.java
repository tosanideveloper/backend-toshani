package com.toshaniFintech.settlement.dto.request;

import com.toshaniFintech.settlement.enums.SettlementStatus;
import com.toshaniFintech.settlement.enums.SettlementTransactionType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SettlementReportRequest {

    private String userUuid;
    private SettlementStatus status;
    private SettlementTransactionType transactionType;
    private LocalDate fromDate;
    private LocalDate toDate;

    // Pagination
    private int pageNo = 0;
    private int pageSize = 10;
    private String sortBy = "createdAt";
    private String orderType = "DESC";
}