package com.toshaniFintech.user_service.model;

import lombok.Data;

import java.util.List;

@Data
public class AmcReportModel {
    private List<String> txnId;

    private String startDate;
    private String endDate;

    private Long pageNo = 0L;
    private Long pageSize = 10L;

    private String search;
    private String searchByField;
    
    private String id;
    private String emiCreateDate;
    private String companyName;
    private String agentDetail;
    private String totalCollectionAmt;
    private String emiAmount;
    private String totalDays;
}
