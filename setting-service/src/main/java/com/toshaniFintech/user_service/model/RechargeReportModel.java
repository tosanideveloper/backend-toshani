package com.toshaniFintech.user_service.model;

import lombok.Data;

@Data
public class RechargeReportModel {

    private String startDate;
    private String endDate;

    private String slNo;
    private String txnDate;
    private String partnerDetails;
    private String txnID;
    private String orderID;
    private String txnType;
    private String operator;
    private String number;
    private String operatorID;
    private String amount;
    private String commission;
    private String tds;
    private String txnStatus;
    private String api;
    private String request;
    private String response;
}