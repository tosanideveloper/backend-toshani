package com.toshaniFintech.user_service.model;

import lombok.Data;

@Data
public class ModifyReportModel {

    private String startDate;
    private String endDate;

    private String txnDate;
    private String partnerDetails;
    private String serviceName;
    private String txnID;
    private String orderID;
    private String accountNumber;
    private String ifsc;
}