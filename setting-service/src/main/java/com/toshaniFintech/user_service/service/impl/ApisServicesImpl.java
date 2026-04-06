package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.user_service.dto.response.ApisServicesResponseDTO;
import com.toshaniFintech.user_service.entity.ApisServicesEntity;
import com.toshaniFintech.user_service.exception.BadRequestException;
import com.toshaniFintech.user_service.exception.NotFoundException;
import com.toshaniFintech.user_service.exception.UnprocessableEntityException;
import com.toshaniFintech.user_service.model.ApisServiceModel;
import com.toshaniFintech.user_service.repository.ApisServicesRepository;
import com.toshaniFintech.user_service.service.ApisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ApisServicesImpl implements ApisService {

    @Autowired
    ApisServicesRepository apisServicesRepository;

    @Autowired
    ObjectMapper objectMapper;


    @Override
    public List<ApisServiceModel> getApisService() {
        List<ApisServicesEntity> apiService = apisServicesRepository.findAll();
        List<ApisServiceModel> apiServicesList = apiService.stream().map(apisServicesEntity -> objectMapper.convertValue(apisServicesEntity, ApisServiceModel.class)).toList();

        return apiServicesList;
    }

    @Override
    public ApisServiceModel createApisService(ApisServiceModel apisServiceModel) {
        if (apisServicesRepository.findByApiName(apisServiceModel.getApiName()).isPresent()) {
            throw new UnprocessableEntityException("Api Name already exists with key: " + apisServiceModel.getApiName());

        }
        ApisServicesEntity apisServicesEntity = new ApisServicesEntity();
        apisServicesEntity.setServiceName(apisServiceModel.getServiceName());
        apisServicesEntity.setApiName(apisServiceModel.getApiName());
        apisServicesEntity.setStatus(apisServiceModel.getStatus());

        ApisServicesEntity saved = apisServicesRepository.save(apisServicesEntity);

        return objectMapper.convertValue(saved, ApisServiceModel.class);
    }


    @Override
    public ApisServiceModel updateApisServices(String id, ApisServiceModel apisServiceModel) {
        ApisServicesEntity apisServicesEntity = apisServicesRepository.findById(id).orElseThrow(() -> new RuntimeException("Setting not found with id: " + id));
        apisServicesEntity.setApiName(apisServiceModel.getApiName());
        apisServicesEntity.setStatus(apisServiceModel.getStatus());


        ApisServicesEntity saved = apisServicesRepository.save(apisServicesEntity);

        return objectMapper.convertValue(saved, ApisServiceModel.class);

    }

    @Override
    public void deleteApisService(String id) {
        ApisServicesEntity existingEntity = apisServicesRepository.findById(id).orElseThrow(() -> new NotFoundException("Apis Service not found with id: " + id));

        if (!existingEntity.isActive()) {
            throw new BadRequestException("Apis Services already deleted");
        }
        existingEntity.setActive(false);
        existingEntity.setDeletedAt(LocalDateTime.now());
        apisServicesRepository.save(existingEntity);
    }

    @Override
    public ApisServiceModel getByID(String id) {
        ApisServicesEntity entity = apisServicesRepository.findById(id).orElseThrow(() -> new NotFoundException("Switching User not found with id: " + id));
        return mapToModel(entity);
    }

    private ApisServiceModel mapToModel(ApisServicesEntity entity) {
        ApisServicesResponseDTO response = new ApisServicesResponseDTO();
        response.setId(entity.getId());
        response.setServiceName(entity.getServiceName());
        response.setApiName(entity.getApiName());
        response.setStatus(entity.getStatus());

        return objectMapper.convertValue(entity, ApisServiceModel.class);
    }

}
