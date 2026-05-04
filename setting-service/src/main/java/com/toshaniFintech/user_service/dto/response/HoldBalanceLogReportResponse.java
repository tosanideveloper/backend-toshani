package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class HoldBalanceLogReportResponse {
    private String id;
    private String txnDate;
    private String partnerDetails;
    private String partnerId;
    private String debitHoldBalanceBefore;
    private String debitHoldBalanceAfter;
    private String creditHoldBalanceBefore;
    private String creditHoldBalanceAfter;
}
