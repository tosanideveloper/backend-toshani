package com.toshaniFintech.user_service.model;

import lombok.Data;

import java.util.List;

@Data
public class HoldBalanceLogReportModel {
    private List<String> partnerId;

    private String startDate;
    private String endDate;

    private Long pageNo = 0L;
    private Long pageSize = 10L;

    private String search;
    private String searchByField;



    private String id;
    private String txnDate;
    private String partnerDetails;
    private String debitHoldBalanceBefore;
    private String debitHoldBalanceAfter;
    private String creditHoldBalanceBefore;
    private String creditHoldBalanceAfter;
}
