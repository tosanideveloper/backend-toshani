package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class ActivityReportResponse {
    private String id;
    private String slNo;
    private String apiUserDetail;
    private String txnDate;
    private String updatedBy;
    private String functionName;
}

