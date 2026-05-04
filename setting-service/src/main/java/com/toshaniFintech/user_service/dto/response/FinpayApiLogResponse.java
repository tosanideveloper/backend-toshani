package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class FinpayApiLogResponse {
    private String id;
    private String txnDate;
    private String partnerName;
    private String partnerId;
    private String source;
    private String url;
}
