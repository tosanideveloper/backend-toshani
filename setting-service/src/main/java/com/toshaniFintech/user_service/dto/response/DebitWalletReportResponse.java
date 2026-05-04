package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class DebitWalletReportResponse {
    private String id;
    private String txnDate;
    private String txnID;
    private String apiTxnId;
    private String status;
    private String apiUserDetails;
    private String openingBalance;
    private String creditDebit;
    private String closingBalance;
    private String adminBalance;
    private String txnDetails;
}
