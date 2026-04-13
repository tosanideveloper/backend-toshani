package com.toshaniFintech.user_service.model;

import lombok.Data;

import java.util.Date;

@Data
public class AffiliateUserModel {
    private String serialNo;
    private String name;
    private String mobileNumber;
    private String email;
    private String walletBalance;
    private String status;
    private String joinedON;
    private String action;
}
