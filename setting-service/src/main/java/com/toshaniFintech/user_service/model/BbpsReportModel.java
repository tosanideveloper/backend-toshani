package com.toshaniFintech.user_service.model;

import lombok.Data;

@Data
public class BbpsReportModel {

    private String startDate;
    private String endDate;

    private String txnDate;
    private String partnerDetails;
    private String txnID;
    private String orderID;
    private String apiRequestID;
    private String type;
    private String billerName;
    private String amount;
    private String charges;
    private String gst;
    private String commission;
    private String tds;
    private String apiStatus;
    private String apiName;
    private String status;
    private String request;
    private String response;
    private String callback;
    private String xmlRequest;
    private String xmlResponse;
}