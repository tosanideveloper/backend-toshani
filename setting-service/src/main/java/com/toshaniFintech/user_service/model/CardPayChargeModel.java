package com.toshaniFintech.user_service.model;

import lombok.Data;

@Data
public class CardPayChargeModel {

    private String id;
    private Double minAmount;
    private Double maxAmount;
    private String chargeType;
    private Double charge;
}