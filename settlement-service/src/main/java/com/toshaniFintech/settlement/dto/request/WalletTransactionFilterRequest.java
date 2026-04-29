package com.toshaniFintech.settlement.dto.request;

import com.toshaniFintech.settlement.enums.WalletTransactionRefType;
import com.toshaniFintech.settlement.enums.WalletTransactionType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class WalletTransactionFilterRequest {

    private String userUuid;
    private WalletTransactionType transactionType;
    private WalletTransactionRefType transactionRefType;
    private LocalDate fromDate;
    private LocalDate toDate;

    private int pageNo = 0;
    private int pageSize = 10;
    private String sortBy = "createdAt";
    private String orderType = "DESC";
}