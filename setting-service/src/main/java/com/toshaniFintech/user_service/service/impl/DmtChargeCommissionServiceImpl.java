package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.exception.model.BadRequestException;
import com.toshaniFintech.common.exception.model.NotFoundException;
import com.toshaniFintech.user_service.dto.request.DmtChargeCommissionRequest;
import com.toshaniFintech.user_service.dto.response.DmtChargeCommissionResponse;
import com.toshaniFintech.user_service.entity.DmtChargeCommissionEntity;
import com.toshaniFintech.user_service.repository.DmtChargeCommissionRepository;
import com.toshaniFintech.user_service.service.DmtChargeCommissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.stream.Collectors;
@Service
public class DmtChargeCommissionServiceImpl implements DmtChargeCommissionService {
    @Autowired
    private DmtChargeCommissionRepository dmtChargeCommissionRepository;

    @Override
    public DmtChargeCommissionResponse createDmtChargeCommission
            (DmtChargeCommissionRequest dmtChargeCommissionRequest) {
        DmtChargeCommissionEntity entity = mapToEntity(dmtChargeCommissionRequest);
        DmtChargeCommissionEntity savedEntity = dmtChargeCommissionRepository.save(entity);
        return mapToModel(savedEntity);
    }

    @Override
    public PaginatedResponse<DmtChargeCommissionResponse> getAllDmtChargeCommission(PageRequest pageRequest) {

        Page<DmtChargeCommissionEntity> dmtChargeCommissionPage = dmtChargeCommissionRepository.findAll(pageRequest);

        PaginatedResponse<DmtChargeCommissionResponse> response =
                new PaginatedResponse<>(dmtChargeCommissionPage);

        response.setContent(
                dmtChargeCommissionPage.getContent()
                        .stream()
                        .map(this::mapToModel)
                        .collect(Collectors.toList())
        );

        return response;
    }

    @Override
    public DmtChargeCommissionResponse getDmtChargeCommissionById(String id) {
        DmtChargeCommissionEntity entity = dmtChargeCommissionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Dmt Charge Commission not found with id: " + id));
        return mapToModel(entity);
    }

    @Override
    public DmtChargeCommissionResponse updateDmtChargeCommission(String id, DmtChargeCommissionRequest dmtChargeCommissionRequest) {
        DmtChargeCommissionEntity existingEntity = dmtChargeCommissionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Dmt Charge Commission not found with id: " + id));

        existingEntity.setMinAmount(dmtChargeCommissionRequest.getMinAmount());
        existingEntity.setMaxAmount(dmtChargeCommissionRequest.getMaxAmount());
        existingEntity.setCommType(dmtChargeCommissionRequest.getCommType());
        existingEntity.setComm(dmtChargeCommissionRequest.getComm());

        DmtChargeCommissionEntity updatedEntity = dmtChargeCommissionRepository.save(existingEntity);
        return mapToModel(updatedEntity);
    }

    @Override
    public void deleteDmtChargeCommission(String id) {
        DmtChargeCommissionEntity existingEntity = dmtChargeCommissionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Dmt Charge Commission not found with id: " + id));

        if (!existingEntity.isActive()) {
            throw new BadRequestException("Dmt Charge Commission already deleted");
        }
        existingEntity.setActive(false);
        existingEntity.setDeletedAt(LocalDateTime.now());
        dmtChargeCommissionRepository.save(existingEntity);
    }

    private DmtChargeCommissionEntity mapToEntity(DmtChargeCommissionRequest model) {
        DmtChargeCommissionEntity entity = new DmtChargeCommissionEntity();
        entity.setMinAmount(model.getMinAmount());
        entity.setMaxAmount(model.getMaxAmount());
        entity.setCommType(model.getCommType());
        entity.setComm(model.getComm());
        return entity;
    }

    private DmtChargeCommissionResponse mapToModel(DmtChargeCommissionEntity entity) {
        DmtChargeCommissionResponse response = new DmtChargeCommissionResponse();
        response.setId(entity.getId());
        response.setMinAmount(entity.getMinAmount());
        response.setMaxAmount(entity.getMaxAmount());
        response.setCommType(entity.getCommType());
        response.setComm(entity.getComm());
        response.setActive(entity.isActive());
        return response;
    }
}
