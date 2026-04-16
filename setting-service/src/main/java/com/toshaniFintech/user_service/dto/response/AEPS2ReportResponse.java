package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class AEPS2ReportResponse {
    private String Id;
    private String slNo;
    private String transactionDate;
    private String partnerName;
    private String partnerId;
    private String transactionId;
    private String orderId;
    private String merchantCode;
    private String apiTransactionId;
    private boolean active;
}
