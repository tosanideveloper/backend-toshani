package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class Aeps3ReportResponse {
    private String Id;
    private String slNo;
    private String partnerName;
    private String partnerId;
    private String txnId;
    private String orderId;
    private String merchantCode;
    private String bankName;
    private String aadhaarNo;
    private String txnType;
    private String amount;
    private String utr;
    private String commission;
    private String tds;
    private String charges;
    private String gst;
    private String transactionDate;
    private String txnStatus;
    private boolean active;
}
