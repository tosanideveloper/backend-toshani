package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class ApiWalletReportResponse {
    private String id;
    private String txnId;
    private String apiName;
    private String openingBalance;
    private String creditDebit;
    private String closingBalance;
    private String key;
    private String updatedBy;
    private String txnDetails;
}
