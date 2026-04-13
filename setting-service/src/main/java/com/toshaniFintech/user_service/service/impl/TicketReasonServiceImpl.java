package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.user_service.dto.response.TicketReasonResponseDTO;
import com.toshaniFintech.user_service.entity.TicketReasonEntity;
import com.toshaniFintech.user_service.exception.NotFoundException;
import com.toshaniFintech.user_service.model.TicketReasonModel;
import com.toshaniFintech.user_service.repository.TicketReasonRepository;
import com.toshaniFintech.user_service.service.TicketReasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketReasonServiceImpl implements TicketReasonService {
    @Autowired
    private TicketReasonRepository ticketReasonRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<TicketReasonModel> getAllTicketReasons() {
        List<TicketReasonEntity> ticketReasonEntityList = ticketReasonRepository.findAll();
        return ticketReasonEntityList.stream().map(ticketReasonEntity -> objectMapper.convertValue(ticketReasonEntity, TicketReasonModel.class)).toList();
    }

    @Override
    public TicketReasonModel createTicketReason(TicketReasonModel ticketReasonModel) {
        TicketReasonEntity ticketReasonEntity = objectMapper.convertValue(ticketReasonModel, TicketReasonEntity.class);
        TicketReasonEntity saved = ticketReasonRepository.save(ticketReasonEntity);
        return objectMapper.convertValue(saved, TicketReasonModel.class);
    }

    @Override
    public TicketReasonModel updateTicketReason(String id, TicketReasonModel ticketReasonModel) {
        ticketReasonRepository.findById(id).orElseThrow(() -> new RuntimeException("Ticket Reason not found with id: " + id));
        TicketReasonEntity ticketReasonEntity = objectMapper.convertValue(ticketReasonModel, TicketReasonEntity.class);
        TicketReasonEntity saved = ticketReasonRepository.save(ticketReasonEntity);
        return objectMapper.convertValue(saved, TicketReasonModel.class);
    }

    @Override
    public void deleteTicketReason(String id) {
        TicketReasonEntity existingEntity = ticketReasonRepository.findById(id).orElseThrow(() -> new NotFoundException("Ticket Details not found with id: " + id));
        existingEntity.setActive(false);
        existingEntity.setDeletedAt(LocalDateTime.now());
        ticketReasonRepository.save(existingEntity);

    }

    @Override
    public TicketReasonModel getTicketReasonByID(String id) {
        TicketReasonEntity entity = ticketReasonRepository.findById(id).orElseThrow(() -> new NotFoundException("Ticket Details not found with id: " + id));
        return mapToModel(entity);
    }

    private TicketReasonModel mapToModel(TicketReasonEntity entity) {
        TicketReasonResponseDTO response = new TicketReasonResponseDTO();
        response.setId(entity.getId());
        response.setCategory(entity.getCategory());
        response.setReason(entity.getReason());
        response.setStatus(entity.getStatus());
        response.setCreatedOn(entity.getCreatedOn());
        return objectMapper.convertValue(entity, TicketReasonModel.class);
    }
}
