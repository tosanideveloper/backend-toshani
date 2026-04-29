package com.toshaniFintech.user_service.model;

import lombok.Data;

@Data
public class TicketReasonModel {
    private String id;
    private String category;
    private String reason;
    private String status;
    private String createdDate;
}
