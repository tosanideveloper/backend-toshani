package com.toshaniFintech.user_service.model;

import lombok.Data;

@Data
public class PayoutChargeCommissionModel {
    private String id;
    private Double minAmount;
    private Double maxAmount;
    private String txnType;
    private String chargeType;
    private Double charge;
}
