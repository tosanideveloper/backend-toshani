package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class MatmReportResponseDTO {

    private String txnDate;
    private String partnerDetails;
    private String txnID;
    private String orderID;
    private String apiTxnID;
    private String cardNo;
    private String txnType;
    private String amount;
    private String utr;
    private String comm;
    private String tds;
    private String status;
    private String responseMessage;
}