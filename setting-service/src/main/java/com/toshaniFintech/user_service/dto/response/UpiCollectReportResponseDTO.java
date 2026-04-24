package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class UpiCollectReportResponseDTO {

    private String id;
    private String date;
    private String apiUserDetail;
    private String requestId;
    private String type;
    private String status;
    private String apiName;
    private String request;
    private String response;
}