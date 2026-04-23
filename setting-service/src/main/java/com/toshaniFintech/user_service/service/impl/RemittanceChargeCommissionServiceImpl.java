package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.exception.model.BadRequestException;
import com.toshaniFintech.common.exception.model.NotFoundException;
import com.toshaniFintech.common.exception.model.UnprocessableEntityException;
import com.toshaniFintech.user_service.dto.request.RemittanceChargeCommissionRequest;;
import com.toshaniFintech.user_service.dto.response.RemittanceChargeCommissionResponse;
import com.toshaniFintech.user_service.entity.RemittanceChargeCommissionEntity;
import com.toshaniFintech.user_service.repository.RemittanceChargeCommissionRepository;
import com.toshaniFintech.user_service.service.RemittanceChargeCommissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
public class RemittanceChargeCommissionServiceImpl implements RemittanceChargeCommissionService {
    @Autowired
    private RemittanceChargeCommissionRepository remittanceChargeCommissionRepository;

    @Override
    public RemittanceChargeCommissionResponse createRemittanceChargeCommission
            (RemittanceChargeCommissionRequest remittanceChargeCommissionRequest) {

        RemittanceChargeCommissionEntity entity = mapToEntity(remittanceChargeCommissionRequest);
        RemittanceChargeCommissionEntity savedEntity = remittanceChargeCommissionRepository.save(entity);
        return mapToModel(savedEntity);
    }

    @Override
    public PaginatedResponse<RemittanceChargeCommissionResponse> getAllRemittanceChargeCommission
            (PageRequest pageRequest) {

        Page<RemittanceChargeCommissionEntity>
                remittanceChargeCommissionPage = remittanceChargeCommissionRepository.findAll(pageRequest);

        PaginatedResponse<RemittanceChargeCommissionResponse> response =
                new PaginatedResponse<>(remittanceChargeCommissionPage);

        response.setContent(
                remittanceChargeCommissionPage.getContent()
                        .stream()
                        .map(this::mapToModel)
                        .collect(Collectors.toList())
        );

        return response;
    }

    @Override
    public RemittanceChargeCommissionResponse getRemittanceChargeCommissionById(String id) {
        RemittanceChargeCommissionEntity entity = remittanceChargeCommissionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Remittance Charge Commission not found with id: " + id));
        return mapToModel(entity);
    }

    @Override
    public RemittanceChargeCommissionResponse updateRemittanceChargeCommission
            (String id, RemittanceChargeCommissionRequest remittanceChargeCommissionRequest) {
        RemittanceChargeCommissionEntity existingEntity = remittanceChargeCommissionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("RemittanceChargeCommission not found with id: " + id));

        existingEntity.setMinAmount(remittanceChargeCommissionRequest.getMinAmount());
        existingEntity.setMaxAmount(remittanceChargeCommissionRequest.getMaxAmount());
        existingEntity.setChargeType(remittanceChargeCommissionRequest.getChargeType());
        existingEntity.setCharge(remittanceChargeCommissionRequest.getCharge());

        RemittanceChargeCommissionEntity updatedEntity = remittanceChargeCommissionRepository.save(existingEntity);
        return mapToModel(updatedEntity);
    }

    @Override
    public void deleteRemittanceChargeCommission(String id) {
        RemittanceChargeCommissionEntity existingEntity = remittanceChargeCommissionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("RemittanceChargeCommission not found with id: " + id));

        if (!existingEntity.isActive()) {
            throw new BadRequestException("RemittanceChargeCommission already deleted");
        }
        existingEntity.setActive(false);
        existingEntity.setDeletedAt(LocalDateTime.now());
        remittanceChargeCommissionRepository.save(existingEntity);
    }
    private RemittanceChargeCommissionEntity mapToEntity(RemittanceChargeCommissionRequest model) {
        RemittanceChargeCommissionEntity entity = new RemittanceChargeCommissionEntity();
        entity.setMinAmount(model.getMinAmount());
        entity.setMaxAmount(model.getMaxAmount());
        entity.setChargeType(model.getChargeType());
        entity.setCharge(model.getCharge());
        return entity;
    }

    private RemittanceChargeCommissionResponse mapToModel(RemittanceChargeCommissionEntity entity) {
        RemittanceChargeCommissionResponse response = new RemittanceChargeCommissionResponse();
        response.setId(entity.getId());
        response.setMinAmount(entity.getMinAmount());
        response.setMaxAmount(entity.getMaxAmount());
        response.setChargeType(entity.getChargeType());
        response.setCharge(entity.getCharge());
        response.setActive(entity.isActive());
        return response;
    }
}
