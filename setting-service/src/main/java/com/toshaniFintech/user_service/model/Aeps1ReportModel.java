package com.toshaniFintech.user_service.model;

import lombok.Data;

import java.util.List;

@Data
public class Aeps1ReportModel {
    // Filters
    private List<String> orderId;
    private List<String> txnId;
    private List<String> txnType;
    private List<String> status;

    // Date Range
    private String startDate;
    private String endDate;

    // Pagination
    private Long pageNo = 0L;
    private Long pageSize = 10L;

    // Search
    private String search;
    private String searchByField;

    // Response Fields
    private String id;
    private String txnDate;
    private String txnID;
    private String orderID;
    private String bankName;
    private String aadhaarNo;
    private String amount;
    private String rrn;
    private String txnStatus;
}
