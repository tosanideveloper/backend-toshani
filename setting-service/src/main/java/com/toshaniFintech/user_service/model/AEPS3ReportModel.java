package com.toshaniFintech.user_service.model;

import lombok.Data;

@Data
public class AEPS3ReportModel {
    private String slNo;
    private String partnerName;
    private String partnerId;
    private String transactionId;
    private String orderId;
    private String merchantCode;
    private String bankName;
    private String aadhaarNo;
    private String transactionType;
    private String amount;
    private String utr;
    private String commission;
    private String tds;
    private String charges;
    private String gst;
    private String transactionDate;
}
