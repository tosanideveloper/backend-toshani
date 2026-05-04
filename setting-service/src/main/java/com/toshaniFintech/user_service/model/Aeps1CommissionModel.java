package com.toshaniFintech.user_service.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Aeps1CommissionModel {

    private String id;
    private Double minAmount;
    private Double maxAmount;
    private String commType;
    private Double commission;
    private LocalDate createDate;
}
