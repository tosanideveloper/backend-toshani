package com.toshaniFintech.user_service.model;

import lombok.Data;

import java.util.List;

@Data
public class HdfcVirtualLogModel {
    private List<String> userId;
    private List<String> status;
    private List<String> userName;
    private List<String> accountNumber;

    private String startDate;
    private String endDate;

    private Long pageNo = 0L;
    private Long pageSize = 10L;

    private String search;
    private String searchByField;

    private String id;
    private String txnDate;
    private String amount;
    private String creditDebit;
    private String userReferenceNumber;
    private String virtualAccount;
}
