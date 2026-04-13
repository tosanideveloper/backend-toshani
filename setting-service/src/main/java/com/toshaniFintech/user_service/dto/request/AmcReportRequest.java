package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class AmcReportRequest {
    @NotBlank(message = "Company name must not be blank")
    private String companyName;

    @NotBlank(message = "Agent details must not be blank")
    private String agentDetail;

    @NotBlank(message = "Transaction ID must not be blank")
    private String txnId;

    @NotNull(message = "EMI create date must not be null")
    private Date emiCreateDate;

    @NotNull(message = "Total collection amount must not be null")
    private BigDecimal totalCollectionAmt;

    @NotNull(message = "EMI amount must not be null")
    private BigDecimal emiAmount;

    private Integer totalDays;

}
