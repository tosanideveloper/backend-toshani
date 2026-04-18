package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RemittanceChargeCommissionResponse {
    private String id;
    private Integer slNo;
    private BigDecimal minAmount;
    private BigDecimal maxAmount;
    private String chargeType;
    private BigDecimal charge;
    private Boolean active;
}
