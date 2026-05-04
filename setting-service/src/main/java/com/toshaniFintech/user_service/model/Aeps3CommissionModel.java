package com.toshaniFintech.user_service.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Aeps3CommissionModel {
    private String id;
    private Double minAmount;
    private Double maxAmount;
    private String transactionType;
    private String commissionType;
    private Double commission;
    private String rrn;
    private LocalDate createDate;
}
