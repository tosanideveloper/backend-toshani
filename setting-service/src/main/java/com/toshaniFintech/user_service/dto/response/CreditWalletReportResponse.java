package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class CreditWalletReportResponse {
    private String id;
    private String txnDate;
    private String txnID;
    private String apiTxnId;
    private String status;
    private String apiUserDetails;
    private String openingBalance;
    private String creditDebit;
    private String closingBalance;
    private String txnDetails;
}
