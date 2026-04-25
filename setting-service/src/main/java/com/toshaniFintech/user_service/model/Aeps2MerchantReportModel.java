package com.toshaniFintech.user_service.model;

import lombok.Data;

@Data
public class Aeps2MerchantReportModel {
    private String startDate;
    private String endDate;

    private Long pageNo = 0L;
    private Long pageSize = 10L;

    private String search;
    private String searchByField;

    private String Id;
    private String slNo;
    private String txnDate;
    private String partnerDetails;
    private String username;
    private String merchantName;
}
