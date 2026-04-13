package com.toshaniFintech.user_service.service;

import com.toshaniFintech.user_service.model.TicketReasonModel;

import java.util.List;

public interface TicketReasonService {
    List<TicketReasonModel> getAllTicketReasons();

    TicketReasonModel createTicketReason(TicketReasonModel ticketReasonModel);

    TicketReasonModel updateTicketReason(String id, TicketReasonModel ticketReasonModel);

    void deleteTicketReason(String id);

    TicketReasonModel getTicketReasonByID(String id);
}
