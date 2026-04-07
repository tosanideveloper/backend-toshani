package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.exception.model.NotFoundException;
import com.toshaniFintech.user_service.dto.response.ManageSettlementResponseDTO;
import com.toshaniFintech.user_service.entity.ManageSettlementEntity;
import com.toshaniFintech.user_service.model.ManageSettlementModel;
import com.toshaniFintech.user_service.repository.ManageSettlementRepository;
import com.toshaniFintech.user_service.service.ManageSettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageSettlementServiceImpl implements ManageSettlementService {

    @Autowired
    private ManageSettlementRepository manageSettlementRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<ManageSettlementModel> getAllSettlementTime() {
        List<ManageSettlementEntity> manageSettlementEntities = manageSettlementRepository.findAll();
        return manageSettlementEntities.stream().map(manageSettlementEntity -> objectMapper.convertValue(manageSettlementEntity, ManageSettlementModel.class)).toList();
    }

    @Override
    public ManageSettlementModel getSettlementTimeById(String id) {
        ManageSettlementEntity entity = manageSettlementRepository.findById(id).orElseThrow(() -> new NotFoundException("Setting not found with id: " + id));
        return mapToModel(entity);
    }

    @Override
    public ManageSettlementModel updateSettlementTime(String id, ManageSettlementModel manageSettlementModel) {
        ManageSettlementEntity manageSettlementEntity = manageSettlementRepository.findById(id).orElseThrow(() -> new NotFoundException("Setting not found with id: " + id));
        manageSettlementEntity.setDay(manageSettlementModel.getDay());
        manageSettlementEntity.setStartTime(manageSettlementModel.getStartTime());
        manageSettlementEntity.setEndTime(manageSettlementModel.getEndTime());

        ManageSettlementEntity saved = manageSettlementRepository.save(manageSettlementEntity);

        return objectMapper.convertValue(saved, ManageSettlementModel.class);
    }

    private ManageSettlementModel mapToModel(ManageSettlementEntity entity) {
        ManageSettlementResponseDTO response = new ManageSettlementResponseDTO();
        response.setId(entity.getId());
        response.setDay(entity.getDay());
        response.setStartTime(entity.getStartTime());
        response.setEndTime(entity.getEndTime());

        return objectMapper.convertValue(entity, ManageSettlementModel.class);
    }

}
