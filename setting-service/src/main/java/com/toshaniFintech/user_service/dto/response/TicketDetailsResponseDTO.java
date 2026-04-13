package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class TicketDetailsResponseDTO {
    private String id;
    private String complaintOn;
    private String ticketId;
    private String partnerDetails;
    private String transactionDate;
    private String transactionStatus;

}
