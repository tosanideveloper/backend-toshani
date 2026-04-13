package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.user_service.dto.response.TicketDetailsResponseDTO;
import com.toshaniFintech.user_service.dto.response.TicketMessagesResponseDTO;
import com.toshaniFintech.user_service.entity.TicketDetailsEntity;
import com.toshaniFintech.user_service.entity.TicketMessagesEntity;
import com.toshaniFintech.user_service.exception.NotFoundException;
import com.toshaniFintech.user_service.model.TicketDetailsModel;
import com.toshaniFintech.user_service.model.TicketMessagesModel;
import com.toshaniFintech.user_service.repository.TicketDetailsRepository;
import com.toshaniFintech.user_service.service.TicketDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketDetailsServiceImpl implements TicketDetailsService {
    @Autowired
    private TicketDetailsRepository ticketDetailsRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<TicketDetailsModel> getAllTickets() {
        List<TicketDetailsEntity> ticketDetailsEntityList = ticketDetailsRepository.findAll();
        return ticketDetailsEntityList.stream().map(ticketDetailsEntity -> objectMapper.convertValue(ticketDetailsEntity, TicketDetailsModel.class)).toList();
    }

    @Override
    public TicketDetailsModel updateTicketDetails(String id, TicketDetailsModel ticketDetailsModel) {
        ticketDetailsRepository.findById(id).orElseThrow(() -> new RuntimeException("Setting not found with id: " + id));
        TicketDetailsEntity ticketDetailsEntity = objectMapper.convertValue(ticketDetailsModel, TicketDetailsEntity.class);
        TicketDetailsEntity saved = ticketDetailsRepository.save(ticketDetailsEntity);
        return objectMapper.convertValue(saved, TicketDetailsModel.class);
    }

    @Override
    public void deleteTickets(String id) {
        TicketDetailsEntity existingEntity = ticketDetailsRepository.findById(id).orElseThrow(() -> new NotFoundException("Ticket Details not found with id: " + id));
        existingEntity.setActive(false);
        existingEntity.setDeletedAt(LocalDateTime.now());
        ticketDetailsRepository.save(existingEntity);
    }

    @Override
    public TicketDetailsModel getTicketByID(String id) {
        TicketDetailsEntity entity = ticketDetailsRepository.findById(id).orElseThrow(() -> new NotFoundException("Ticket Details not found with id: " + id));
        return mapToModel(entity);
    }
    private TicketDetailsModel mapToModel(TicketDetailsEntity entity) {
        TicketDetailsResponseDTO response = new TicketDetailsResponseDTO();
        response.setId(entity.getId());
        response.setComplaintOn(entity.getComplaintOn());
        response.setTicketId(entity.getTicketId());
        response.setPartnerDetails(entity.getPartnerDetails());
        response.setTransactionDate(entity.getTransactionDate());
        response.setTransactionStatus(entity.getTransactionStatus());
        return objectMapper.convertValue(entity, TicketDetailsModel.class);
    }
}
