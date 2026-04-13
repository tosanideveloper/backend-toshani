package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TicketDetailsRequestDTO {
    @NotBlank(message = "Complaint on must not be blank")
    private String complaintOn;

    @NotBlank(message = "Ticket ID must not be blank")
    private String ticketId;

    @NotBlank(message = "Partner Details must not be blank")
    private String partnerDetails;

    @NotBlank(message = "Transaction Date must not be blank")
    private String transactionDate;

    @NotBlank(message = "Transaction status must not be blank")
    private String transactionStatus;
}
