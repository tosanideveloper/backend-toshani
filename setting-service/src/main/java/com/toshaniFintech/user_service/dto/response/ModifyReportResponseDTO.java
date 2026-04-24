package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class ModifyReportResponseDTO {

    private String txnDate;
    private String partnerDetails;
    private String serviceName;
    private String txnID;
    private String orderID;
    private String accountNumber;
    private String ifsc;
}