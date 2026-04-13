package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.user_service.dto.response.TicketMessagesResponseDTO;
import com.toshaniFintech.user_service.entity.TicketDetailsEntity;
import com.toshaniFintech.user_service.entity.TicketMessagesEntity;
import com.toshaniFintech.user_service.exception.NotFoundException;
import com.toshaniFintech.user_service.model.TicketMessagesModel;
import com.toshaniFintech.user_service.repository.TicketMessageRepository;
import com.toshaniFintech.user_service.service.TicketMessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable_;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class TicketMessagesServiceImpl implements TicketMessagesService {
    @Autowired
    private TicketMessageRepository ticketMessageRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<TicketMessagesModel> getTicketMessages() {
        List<TicketMessagesEntity> ticketMessagesEntityList = ticketMessageRepository.findAll();
        return ticketMessagesEntityList.stream().map(ticketMessages -> objectMapper.convertValue(ticketMessages, TicketMessagesModel.class)).toList();
    }

    @Override
    public TicketMessagesModel createTicketMessages(TicketMessagesModel ticketMessagesModel) {
        TicketMessagesEntity ticketMessagesEntity = objectMapper.convertValue(ticketMessagesModel, TicketMessagesEntity.class);
        TicketMessagesEntity saved = ticketMessageRepository.save(ticketMessagesEntity);
        return objectMapper.convertValue(saved, TicketMessagesModel.class);
    }

    @Override
    public TicketMessagesModel updateTicketMessage(String id, TicketMessagesModel ticketMessagesModel) {
        ticketMessageRepository.findById(id).orElseThrow(() -> new RuntimeException("Messages not found with id: " + id));
        TicketMessagesEntity ticketMessagesEntity = objectMapper.convertValue(ticketMessagesModel, TicketMessagesEntity.class);
        TicketMessagesEntity saved = ticketMessageRepository.save(ticketMessagesEntity);
        return objectMapper.convertValue(saved, TicketMessagesModel.class);
    }

    @Override
    public void deleteTicketMessage(String id) {
        TicketMessagesEntity existingEntity = ticketMessageRepository.findById(id).orElseThrow(() -> new NotFoundException("Messages not found with id: " + id));
        existingEntity.setActive(false);
        existingEntity.setDeletedAt(LocalDateTime.now());
        ticketMessageRepository.save(existingEntity);
    }

    @Override
    public TicketMessagesModel getTicketMessageByID(String id) {
        TicketMessagesEntity entity = ticketMessageRepository.findById(id).orElseThrow(() -> new NotFoundException("Messages not found with id: " + id));
        return mapToModel(entity);
    }

    private TicketMessagesModel mapToModel(TicketMessagesEntity entity) {
        TicketMessagesResponseDTO response = new TicketMessagesResponseDTO();
        response.setId(entity.getId());
        response.setMessage(entity.getMessage());
        response.setCategory(entity.getCategory());
        response.setStatus(entity.getStatus());

        return objectMapper.convertValue(entity, TicketMessagesModel.class);
    }
}
