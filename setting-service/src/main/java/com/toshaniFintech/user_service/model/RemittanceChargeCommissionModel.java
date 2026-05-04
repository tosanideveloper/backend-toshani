package com.toshaniFintech.user_service.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RemittanceChargeCommissionModel {
    private String id;
    private Double minAmount;
    private Double maxAmount;
    private String chargeType;
    private Double charge;
}
