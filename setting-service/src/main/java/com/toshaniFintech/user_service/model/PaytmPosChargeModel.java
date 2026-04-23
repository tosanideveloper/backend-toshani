package com.toshaniFintech.user_service.model;

import lombok.Data;

@Data
public class PaytmPosChargeModel {

    private String id;

    private Double minAmount;
    private Double maxAmount;
    private String paymentMode;
    private String chargeType;
    private Double charge;
}