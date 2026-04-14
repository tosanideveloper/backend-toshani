package com.toshaniFintech.user_service.dto.response;

import lombok.Data;
import org.hibernate.mapping.List;

import java.time.LocalDateTime;

@Data
public class ComplaintResponse {

    private String slNo;
    private String complaintId;
    private LocalDateTime complaintOn;
    private String agentDetails;
    private String requestUrl;
    private String request;
    private String response;
    private String complaintOnType;
    private String attachment;
    private String status;
    private List messages;

}
