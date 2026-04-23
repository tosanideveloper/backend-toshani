package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class Aeps2ReportResponseDTO {

    private String txnDate;
    private String partnerDetails;
    private String txnID;
    private String orderID;
    private String merchantCode;
    private String apiTxnID;
}