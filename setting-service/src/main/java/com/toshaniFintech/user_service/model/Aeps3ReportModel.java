package com.toshaniFintech.user_service.model;

import lombok.Data;

import java.util.List;

@Data
public class Aeps3ReportModel {
    private List<String> orderId;
    private List<String> txnId;
    private List<String> txnType;
    private List<String> status;

    private String startDate;
    private String endDate;

    private Long pageNo = 0L;
    private Long pageSize = 10L;

    private String search;
    private String searchByField;

    private String Id;
    private String slNo;
    private String partnerName;
    private String partnerId;
    private String merchantCode;
    private String bankName;
    private String aadhaarNo;
    private String amount;
    private String utr;
    private String commission;
    private String tds;
    private String charges;
    private String gst;
    private String txnDate;
}
