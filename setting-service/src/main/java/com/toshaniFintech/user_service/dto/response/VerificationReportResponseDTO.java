package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class VerificationReportResponseDTO {

    private String txnDate;
    private String partnerDetails;
    private String requestID;
    private String type;
    private String status;
    private String request;
    private String response;
}