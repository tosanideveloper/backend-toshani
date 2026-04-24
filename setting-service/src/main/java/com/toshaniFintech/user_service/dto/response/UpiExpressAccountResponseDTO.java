package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class UpiExpressAccountResponseDTO {

    private String id;
    private String accountNo;
    private Double limitAmount;
    private String txnDate;
}