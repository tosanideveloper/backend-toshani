package com.toshaniFintech.user_service.model;

import lombok.Data;

import java.util.Date;

@Data
public class CallBackLogModel {
    private String serialNo;
    private Date transactionDate;
    private String partnerDetails;
    private String source;
    private String callBackUrl;
}
