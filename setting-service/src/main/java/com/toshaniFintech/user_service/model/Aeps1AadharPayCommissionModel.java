package com.toshaniFintech.user_service.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Aeps1AadharPayCommissionModel {
    private String id;
    private Double minAmount;
    private Double maxAmount;
    private String chargeType;
    private Double charge;
    private LocalDate createDate;
}
