package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RemittanceChargeCommissionResponse {
    private String id;
    private Integer slNo;
    private Double minAmount;
    private Double maxAmount;
    private String chargeType;
    private Double charge;
}
