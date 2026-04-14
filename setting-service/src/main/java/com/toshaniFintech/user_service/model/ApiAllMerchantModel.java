package com.toshaniFintech.user_service.model;

import lombok.Data;

@Data
public class ApiAllMerchantModel {
    private String id;
    private String merchant;
    private String mobile;
    private String email;
    private String isPanVerified;
    private String isAadhaarCardVerified;
    private String isAadhaarNoVerified;
    private String status;
}
