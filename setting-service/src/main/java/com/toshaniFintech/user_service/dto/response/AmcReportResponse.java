package com.toshaniFintech.user_service.dto.response;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class AmcReportResponse {
    private String slNo;
    private Date emiCreateDate;
    private String companyName;
    private String agentDetail;
    private String txnId;
    private String totalCollectionAmt;
    private BigDecimal emiAmount;
    private String totalDays;
}
