package com.toshaniFintech.user_service.model;

import lombok.Data;

@Data
public class CreditWalletReportModel {
    private String id;
    private String txnDate;
    private String txnId;
    private String apiTxnId;
    private String status;
    private String apiUserDetails;
    private String openingBalance;
    private String creditDebit;
    private String closingBalance;
    private String txnDetails;
}
