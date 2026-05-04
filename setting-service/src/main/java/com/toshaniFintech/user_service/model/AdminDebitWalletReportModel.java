package com.toshaniFintech.user_service.model;

import lombok.Data;

import java.util.List;

@Data
public class AdminDebitWalletReportModel {
    private List<String> txnId;

    private String startDate;
    private String endDate;


    private Long pageNo = 0L;
    private Long pageSize = 10L;

    private String search;
    private String searchByField;

    private String Id;
    private String apiUserDetails;
    private String openingBalance;
    private String creditDebit;
    private String closingBalance;
    private String key;
    private String updatedBy;
    private String txnDetails;
}
