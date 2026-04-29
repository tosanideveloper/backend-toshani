package com.toshaniFintech.user_service.model;

import lombok.Data;

@Data
public class PartnerManagementModel {
    private String id;
    private String serialNo;
    private String name;
    private String mobileNumber;
    private String email;
    private String walletBalance;
    private String status;
    private String joinedON;
    private String action;
}
