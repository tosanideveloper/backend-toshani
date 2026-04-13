package com.toshaniFintech.user_service.model;

import lombok.Data;

@Data
public class TicketDetailsModel {
    private String id;
    private String complaintOn;
    private String ticketId;
    private String partnerDetails;
    private String transactionDate;
    private String transactionStatus;
}
