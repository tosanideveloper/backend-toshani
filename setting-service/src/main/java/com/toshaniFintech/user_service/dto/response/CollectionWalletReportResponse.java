package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class CollectionWalletReportResponse {
    private String id;
    private String txnID;
    private String apiUserDetails;
    private String openingBalance;
    private String creditDebit;
    private String closingBalance;
    private String txnDetails;
}
