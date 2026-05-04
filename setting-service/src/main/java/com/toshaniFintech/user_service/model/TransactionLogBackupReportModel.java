package com.toshaniFintech.user_service.model;

import lombok.Data;

@Data
public class TransactionLogBackupReportModel {
    private String startDate;
    private String endDate;

    private Long pageNo = 0L;
    private Long pageSize = 10L;

    private String search;
    private String searchByField;

    private String id;
    private String txnDate;
    private String apiUserDetails;
    private String txnID;
    private String orderID;
    private String accountNumber;
    private String ifsc;
    private String bankName;
    private String utr;
    private String txnType;
    private String amount;
    private String charges;
    private String gst;
    private String commission;
    private String tds;
    private String txnStatus;
    private String apiName;
}
