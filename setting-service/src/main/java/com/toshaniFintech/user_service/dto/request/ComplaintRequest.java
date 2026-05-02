package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ComplaintRequest {

    @NotBlank(message = "complaintId must not be blank")
    @Size(max = 50)
    private String complaintId;

    @NotNull(message = "complaintOn must not be null")
    private LocalDate complaintOn;

    @NotBlank(message = "agentDetails must not be blank")
    private String agentDetails;

    @NotBlank(message = "requestUrl must not be blank")
    private String requestUrl;

    @NotBlank(message = "request must not be blank")
    private String request;

    @NotBlank(message = "response must not be blank")
    private String response;

    @NotBlank(message = "status must not be blank")
    private String status;

    private String attachment;

    private List<String> messages;
}