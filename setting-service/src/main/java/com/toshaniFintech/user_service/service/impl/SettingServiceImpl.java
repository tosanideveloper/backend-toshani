package com.toshaniFintech.user_service.service.impl;


import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.SettingRequest;
import com.toshaniFintech.user_service.dto.response.SettingResponse;
import com.toshaniFintech.user_service.entity.SettingEntity;
import com.toshaniFintech.common.exception.model.BadRequestException;
import com.toshaniFintech.common.exception.model.NotFoundException;
import com.toshaniFintech.common.exception.model.UnprocessableEntityException;
import com.toshaniFintech.user_service.repository.SettingRepository;
import com.toshaniFintech.user_service.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SettingServiceImpl implements SettingService {

    @Autowired
    private SettingRepository settingRepository;

    @Override
    public SettingResponse createSetting(SettingRequest settingRequest) {

        if (settingRepository.findBySettingKey(settingRequest.getSettingKey()).isPresent()) {
            throw new UnprocessableEntityException(
                    "Setting already exists with key: " + settingRequest.getSettingKey()
            );
        }
        SettingEntity entity = mapToEntity(settingRequest);
        SettingEntity savedEntity = settingRepository.save(entity);
        return mapToModel(savedEntity);
    }

    @Override
    public PaginatedResponse<SettingResponse> getAllSettings(PageRequest pageRequest) {

        Page<SettingEntity> settingPage = settingRepository.findAll(pageRequest);

        PaginatedResponse<SettingResponse> response =
                new PaginatedResponse<>(settingPage);

        response.setContent(
                settingPage.getContent()
                        .stream()
                        .map(this::mapToModel)
                        .collect(Collectors.toList())
        );

        return response;
    }

    @Override
    public SettingResponse getSettingById(String id) {
        SettingEntity entity = settingRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Setting not found with id: " + id));
        return mapToModel(entity);
    }

    @Override
    public SettingResponse updateSetting(String id, SettingRequest settingRequest) {
        SettingEntity existingEntity = settingRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Setting not found with id: " + id));

        existingEntity.setSettingKey(settingRequest.getSettingKey());
        existingEntity.setSettingValue(settingRequest.getSettingValue());
        existingEntity.setDescription(settingRequest.getDescription());

        SettingEntity updatedEntity = settingRepository.save(existingEntity);
        return mapToModel(updatedEntity);
    }

    @Override
    public void deleteSetting(String id) {
        SettingEntity existingEntity = settingRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Setting not found with id: " + id));

        if (!existingEntity.isActive()) {
            throw new BadRequestException("Setting already deleted");
        }
        existingEntity.setActive(false);
        existingEntity.setDeletedAt(LocalDateTime.now());
        settingRepository.save(existingEntity);
    }

    private SettingEntity mapToEntity(SettingRequest model) {
        SettingEntity entity = new SettingEntity();
        entity.setSettingKey(model.getSettingKey());
        entity.setSettingValue(model.getSettingValue());
        entity.setDescription(model.getDescription());
        return entity;
    }

    private SettingResponse mapToModel(SettingEntity entity) {
        SettingResponse response = new SettingResponse();
        response.setId(entity.getId());
        response.setSettingKey(entity.getSettingKey());
        response.setSettingValue(entity.getSettingValue());
        response.setDescription(entity.getDescription());
        response.setActive(entity.isActive());
        return response;
    }
}