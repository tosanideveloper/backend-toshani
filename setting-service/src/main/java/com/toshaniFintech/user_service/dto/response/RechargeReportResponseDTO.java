package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class RechargeReportResponseDTO {

    private String txnDate;
    private String partnerDetails;
    private String txnID;
    private String orderID;
    private String type;
    private String operator;
    private String number;
    private String operatorID;
    private String amount;
    private String commission;
    private String tds;
    private String status;
    private String api;
    private String request;
    private String response;
}