package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class AEPS2MerchantReportResponse {
    private String Id;
    private String slNo;
    private String date;
    private String partnerDetails;
    private String username;
    private String merchantName;
    private boolean active;
}
