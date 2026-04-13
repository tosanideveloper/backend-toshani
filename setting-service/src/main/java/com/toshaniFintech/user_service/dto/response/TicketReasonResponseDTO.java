package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class TicketReasonResponseDTO {
    private String id;
    private String category;
    private String reason;
    private String status;
    private String createdOn;
}
