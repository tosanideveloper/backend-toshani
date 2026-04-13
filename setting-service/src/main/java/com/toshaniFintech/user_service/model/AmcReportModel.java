package com.toshaniFintech.user_service.model;

import lombok.Data;

@Data
public class AmcReportModel {
    private String slNo;
    private String emiCreateDate;
    private String companyName;
    private String agentDetail;
    private String txnId;
    private String totalCollectionAmt;
    private String emiAmount;
    private String totalDays;
}
