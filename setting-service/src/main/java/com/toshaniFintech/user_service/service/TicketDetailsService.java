package com.toshaniFintech.user_service.service;

import com.toshaniFintech.user_service.model.TicketDetailsModel;

import java.util.List;

public interface TicketDetailsService {
    List<TicketDetailsModel> getAllTickets();

    TicketDetailsModel updateTicketDetails(String id, TicketDetailsModel ticketDetailsModel);

    void deleteTickets(String id);

    TicketDetailsModel getTicketByID(String id);

}
