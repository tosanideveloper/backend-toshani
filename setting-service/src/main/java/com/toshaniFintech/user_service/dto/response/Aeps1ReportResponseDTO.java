package com.toshaniFintech.user_service.dto.response;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class Aeps1ReportResponseDTO {

    private String id;
    private String txnDate;
    private String txnID;
    private String orderID;
    private String bankName;
    private String aadhaarNo;
    private String txnType;
    private String amount;
    private String rrn;
    private String txnStatus;
}
