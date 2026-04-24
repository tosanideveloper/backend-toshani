package com.toshaniFintech.user_service.model;

import lombok.Data;

import java.util.List;

@Data
public class AmcReportModel {
    private List<String> txnId;

    private String startDate;
    private String endDate;

    private int pageNo;
    private int pageSize;

    private String sortBy;
    private String search;
    private String searchByField;

    private String slNo;
    private String emiCreateDate;
    private String companyName;
    private String agentDetail;
    private String totalCollectionAmt;
    private String emiAmount;
    private String totalDays;
}
