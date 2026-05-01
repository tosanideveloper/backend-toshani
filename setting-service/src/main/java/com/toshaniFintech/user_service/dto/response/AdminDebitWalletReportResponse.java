package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class AdminDebitWalletReportResponse {
    private String id;
    private String txnId;
    private String apiUserDetails;
    private String openingBalance;
    private String creditDebit;
    private String closingBalance;
    private String key;
    private String updatedBy;
    private String txnDetails;
}

