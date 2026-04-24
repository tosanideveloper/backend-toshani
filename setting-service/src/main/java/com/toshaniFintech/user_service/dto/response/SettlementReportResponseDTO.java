package com.toshaniFintech.user_service.dto.response;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.Date;

@Data
public class SettlementReportResponseDTO {
    private Date txnDate;
    private String partnerDetails;
    private String txnID;
    private String orderID;
    private String apiTxnID;
    private String accNo;
    private String ifscCode;
    private String bankName;
    private String utr;
    private String txnStatus;
    private String rrn;
    private String txnType;
    private String amount;
    private String charges;
    private String gstNo;
    private String apiName;
    private String request;
    private String response;
    private String callback;
}
