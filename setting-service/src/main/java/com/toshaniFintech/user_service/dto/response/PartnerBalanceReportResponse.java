package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class PartnerBalanceReportResponse {
    private String Id;
    private String txnDate;
    private String companyDetails;
    private String userId;
    private String userType;
    private String debitBalance;
    private String creditBalance;
    private String virtualBalance;
    private String actualBalance;
}
