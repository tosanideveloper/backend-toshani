package com.toshaniFintech.user_service.model;

import lombok.Data;

@Data
public class FinpayApiLogModel {
    private String partnerId;

    private String startDate;
    private String endDate;

    private Long pageNo = 0L;
    private Long pageSize = 10L;

    private String search;
    private String searchByField;

    private String id;
    private String txnDate;
    private String partnerName;
    private String source;
    private String url;
}
