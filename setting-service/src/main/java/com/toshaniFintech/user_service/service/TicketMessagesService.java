package com.toshaniFintech.user_service.service;

import com.toshaniFintech.user_service.model.ApisServiceModel;
import com.toshaniFintech.user_service.model.TicketMessagesModel;

import java.util.List;

public interface TicketMessagesService {
    List<TicketMessagesModel> getTicketMessages();

    TicketMessagesModel createTicketMessages(TicketMessagesModel ticketMessagesModel);

    TicketMessagesModel updateTicketMessage(String id, TicketMessagesModel ticketMessagesModel);

    void deleteTicketMessage(String id);

    TicketMessagesModel getTicketMessageByID(String id);

}
