package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.exception.model.NotFoundException;
import com.toshaniFintech.user_service.dto.response.PartnerManagementResponseDTO;
import com.toshaniFintech.user_service.entity.PartnerManagementEntity;
import com.toshaniFintech.user_service.model.PartnerManagementModel;
import com.toshaniFintech.user_service.repository.PartnerManagementRepository;
import com.toshaniFintech.user_service.service.PartnerManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable_;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class PartnerManagementImpl implements PartnerManagementService {
    @Autowired
    private PartnerManagementRepository partnerManagementRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<PartnerManagementModel> getPartnerManagement() {
        List<PartnerManagementEntity> partnerManagementEntities = partnerManagementRepository.findAll();
        return partnerManagementEntities.stream().map(partnerManagementEntity -> objectMapper.convertValue(partnerManagementEntity, PartnerManagementModel.class)).toList();
    }

    @Override
    public PartnerManagementModel createPartnerManagement(PartnerManagementModel partnerManagementModel) {
        PartnerManagementEntity partnerManagementEntity = partnerManagementRepository.findById(String.valueOf(AbstractPersistable_.id)).orElseThrow(() -> new NotFoundException("Messages not found with id: " + id));
        partnerManagementEntity.setSerialNo(partnerManagementModel.getSerialNo());
        partnerManagementEntity.setName(partnerManagementModel.getName());
        partnerManagementEntity.setStatus(partnerManagementModel.getStatus());
        partnerManagementEntity.setEmail(partnerManagementModel.getEmail());
        partnerManagementEntity.setAction(partnerManagementModel.getAction());
        partnerManagementEntity.setJoinedON(partnerManagementModel.getJoinedON());
        PartnerManagementEntity saved = partnerManagementRepository.save(partnerManagementEntity);

        return objectMapper.convertValue(saved, PartnerManagementModel.class);
    }

    @Override
    public PartnerManagementModel updatePartnerManagement(String id, PartnerManagementModel partnerManagementModel) {
        PartnerManagementEntity partnerManagementEntity = partnerManagementRepository.findById(String.valueOf(AbstractPersistable_.id)).orElseThrow(() -> new NotFoundException("Messages not found with id: " + id));
        partnerManagementEntity.setSerialNo(partnerManagementModel.getSerialNo());
        partnerManagementEntity.setName(partnerManagementModel.getName());
        partnerManagementEntity.setStatus(partnerManagementModel.getStatus());
        partnerManagementEntity.setEmail(partnerManagementModel.getEmail());
        partnerManagementEntity.setAction(partnerManagementModel.getAction());
        partnerManagementEntity.setJoinedON(partnerManagementModel.getJoinedON());
        PartnerManagementEntity saved = partnerManagementRepository.save(partnerManagementEntity);
        return objectMapper.convertValue(saved, PartnerManagementModel.class);

    }

    @Override
    public void deletePartnerManagement(String id) {
        PartnerManagementEntity existingEntity = partnerManagementRepository.findById(id).orElseThrow(() -> new NotFoundException("Admin email not found with id: " + id));
        existingEntity.setActive(false);
        existingEntity.setDeletedAt(LocalDateTime.now());
        partnerManagementRepository.save(existingEntity);

    }

    @Override
    public PartnerManagementModel getPartnerManagementByID(String id) {
        PartnerManagementEntity entity = partnerManagementRepository.findById(id).orElseThrow(() -> new NotFoundException("Admin email not found with id: " + id));
        return mapToModel(entity);
    }

    private PartnerManagementModel mapToModel(PartnerManagementEntity entity) {
        PartnerManagementResponseDTO response = new PartnerManagementResponseDTO();
        response.setName(entity.getName());
        response.setMobileNumber(entity.getMobileNumber());
        response.setEmail(entity.getEmail());

        return objectMapper.convertValue(entity, PartnerManagementModel.class);
    }
}
