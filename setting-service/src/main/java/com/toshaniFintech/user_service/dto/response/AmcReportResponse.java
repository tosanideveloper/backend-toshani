package com.toshaniFintech.user_service.dto.response;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class AmcReportResponse {
    private String id;
    private String slNo;
    private String emiCreateDate;
    private String companyName;
    private String agentDetail;
    private String txnId;
    private String totalCollectionAmt;
    private String emiAmount;
    private Integer totalDays;
}
