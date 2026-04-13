package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ComplaintRequest {
    @NotBlank(message = "complaintId must not be blank")
    @Size(max = 50, message = "complaintId must not exceed 50 characters")
    private String complaintId;

    @NotBlank(message = "complaintOn must not be blank")
    private LocalDateTime complaintOn;

    @NotBlank(message = "agentDetails must not be blank")
    @Size(max = 255, message = "agentDetails must not exceed 255 characters")
    private String agentDetails;

    @NotBlank(message = "requestUrl must not be blank")
    @Size(max = 500, message = "requestUrl must not exceed 500 characters")
    private String requestUrl;

    @NotBlank(message = "request must not be blank")
    private String request;

    @NotBlank(message = "response must not be blank")
    private String response;

    @NotBlank(message = "status must not be blank")
    private String status;

    private String attachment;

    private List <String>messages;

}
