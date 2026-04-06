package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.user_service.entity.ApiPartnerServiceEntity;
import com.toshaniFintech.user_service.exception.BadRequestException;
import com.toshaniFintech.user_service.exception.NotFoundException;
import com.toshaniFintech.user_service.exception.UnprocessableEntityException;
import com.toshaniFintech.user_service.model.ApiPartnerServiceModel;
import com.toshaniFintech.user_service.repository.ApiPartnerServicesRepository;
import com.toshaniFintech.user_service.service.ApiPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable_;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class ApiPartnerServiceImpl implements ApiPartnerService {
    @Autowired
    ApiPartnerServicesRepository apiPartnerServicesRepository;

    @Autowired
    ObjectMapper objectMapper;


    @Override
    public List<ApiPartnerServiceModel> getAllApiPartnerServices() {
        List<ApiPartnerServiceEntity> apiPartnerServiceEntityList = apiPartnerServicesRepository.findAll();
        return apiPartnerServiceEntityList.stream().map(apiPartnerServiceEntity -> objectMapper.convertValue(apiPartnerServiceEntity, ApiPartnerServiceModel.class)).toList();
    }

    @Override
    public ApiPartnerServiceModel createApisPartnerService(ApiPartnerServiceModel apiPartnerServiceModel) {
        if (apiPartnerServicesRepository.findByServiceNameKey(apiPartnerServiceModel.getServiceName()).isPresent()) {
            throw new UnprocessableEntityException(
                    "Setting already exists with key: " + apiPartnerServiceModel.getServiceName()
            );
        }
        ApiPartnerServiceEntity apiPartnerServiceEntity = apiPartnerServicesRepository.findById(String.valueOf(AbstractPersistable_.id)).orElseThrow(() -> new RuntimeException("Setting not found with id: " + id));
        apiPartnerServiceEntity.setPartnerDetails(apiPartnerServiceModel.getPartnerDetails());
        apiPartnerServiceEntity.setDate(apiPartnerServiceModel.getDate());
        apiPartnerServiceEntity.setStatus(apiPartnerServiceModel.getStatus());
        apiPartnerServiceEntity.setServiceName(apiPartnerServiceModel.getServiceName());
        apiPartnerServiceEntity.setRemarks(apiPartnerServiceModel.getRemarks());

        ApiPartnerServiceEntity saved = apiPartnerServicesRepository.save(apiPartnerServiceEntity);

        return objectMapper.convertValue(saved, ApiPartnerServiceModel.class);
    }

    @Override
    public void deleteApiPartnerService(String id) {
        ApiPartnerServiceEntity existingEntity = apiPartnerServicesRepository.findById(id).orElseThrow(() -> new NotFoundException("Apis Service not found with id: " + id));

        if (!existingEntity.isActive()) {
            throw new BadRequestException("Api Partner Services already deleted");
        }
        existingEntity.setActive(false);
        existingEntity.setDeletedAt(LocalDateTime.now());
        apiPartnerServicesRepository.save(existingEntity);
    }
}
