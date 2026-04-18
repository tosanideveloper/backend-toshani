package com.toshaniFintech.user_service.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RemittanceChargeCommissionModel {
    private String slNo;
    private BigDecimal minAmount;
    private BigDecimal maxAmount;
    private String chargeType;
    private BigDecimal charge;
}
