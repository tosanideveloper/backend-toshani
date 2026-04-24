package com.toshaniFintech.user_service.model;

import lombok.Data;

@Data
public class UpiExpressAccountModel {

    private String id;
    private String accountNo;
    private Double limitAmount;
    private String txnDate;
}