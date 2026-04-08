package com.toshaniFintech.user_service.model;

import lombok.Data;

@Data
public class MerchantBankAccModel {

    private String serialNo;
    private String apiPartnerName;
    private String bankName;
    private String accNo;
    private String accHolderName;
}
