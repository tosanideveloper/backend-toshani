package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class HdfcVirtualLogResponse {
    private String id;
    private String txnDate;
    private String userId;
    private String userName;
    private String accountNumber;
    private String amount;
    private String creditDebit;
    private String userReferenceNumber;
    private String virtualAccount;
    private String status;
}
