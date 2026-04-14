package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class ActivityReportResponse {
    private String Id;
    private String apiUserDetail;
    private String date;
    private String updatedBy;
    private String functionName;

}

