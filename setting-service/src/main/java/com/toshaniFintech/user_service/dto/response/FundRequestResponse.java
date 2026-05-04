package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class FundRequestResponse {
    private String id;
    private String requestId;
    private String partnerId;
    private String companyName;
    private String bankName;
    private String accountNo;
    private String ifscCode;
    private String image;


}
