package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class Dmt3ReportResponseDTO {

    private String id;
    private String transactionDate;
    private String apiUserDetails;
    private String transactionId;
    private String orderId;
    private String accountNumber;
    private String ifsc;
    private String bank;
    private String utr;
    private String type;
    private String amount;
    private String charges;
    private String gst;
    private String commission;
    private String tds;
    private String status;
    private String apiName;
    private String request;
    private String response;
}