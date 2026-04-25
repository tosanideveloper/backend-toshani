package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class Aeps2MerchantReportResponse {
    private String Id;
    private String slNo;
    private String txnDate;
    private String partnerDetails;
    private String userName;
    private String merchantName;
    private boolean active;
}
