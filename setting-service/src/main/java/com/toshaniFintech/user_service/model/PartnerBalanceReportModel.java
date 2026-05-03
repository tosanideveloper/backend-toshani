package com.toshaniFintech.user_service.model;

import lombok.Data;

import java.util.List;

@Data
public class PartnerBalanceReportModel {
    private List<String> userId;

    private String startDate;
    private String endDate;

    private Long pageNo = 0L;
    private Long pageSize = 10L;

    private String search;
    private String searchByField;

    private String Id;
    private String txnDate;
    private String companyDetails;
    private String userType;
    private String debitBalance;
    private String creditBalance;
    private String virtualBalance;
    private String actualBalance;
}
