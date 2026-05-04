package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ComplaintResponse {

    private String id;
    private String complaintId;
    private LocalDate complaintOn;
    private String agentDetails;
    private String requestUrl;
    private String request;
    private String response;
    private String attachment;
    private String status;
    private List<String> messages;
}