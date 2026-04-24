package com.toshaniFintech.user_service.model;

import lombok.Data;

@Data
public class VerificationReportModel {

    private String startDate;
    private String endDate;

    private String txnDate;
    private String partnerDetails;
    private String requestID;
    private String type;
    private String status;
    private String request;
    private String response;
}