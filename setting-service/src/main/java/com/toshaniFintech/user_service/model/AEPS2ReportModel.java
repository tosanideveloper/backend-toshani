package com.toshaniFintech.user_service.model;

import lombok.Data;

@Data
public class AEPS2ReportModel {
    private String slNo;
    private String transactionDate;
    private String partnerName;
    private String partnerId;
    private String transactionId;
    private String orderId;
    private String merchantCode;
    private String apiTransactionId;
}
