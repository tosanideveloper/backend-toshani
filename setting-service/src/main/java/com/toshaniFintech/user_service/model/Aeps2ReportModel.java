package com.toshaniFintech.user_service.model;

import lombok.Data;

@Data
public class Aeps2ReportModel {

    private String startDate;
    private String endDate;

    private String txnDate;
    private String partnerDetails;
    private String txnID;
    private String orderID;
    private String merchantCode;
    private String apiTxnID;
}