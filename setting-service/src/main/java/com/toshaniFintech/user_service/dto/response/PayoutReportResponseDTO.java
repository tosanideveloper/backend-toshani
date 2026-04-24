package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class PayoutReportResponseDTO {

    private String id;
    private String transactionDate;
    private String partnerDetails;
    private String transactionId;
    private String orderId;
    private String apiTransactionId;
    private String accountNumber;
    private String ifsc;
    private String bank;
    private String utr;
    private String type;
    private String amount;
    private String charges;
    private String gst;
    private String status;
    private String apiName;
    private String request;
    private String response;
    private String callback;
    private String details;
    private String callbackStatus;
}