package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.exception.model.BadRequestException;
import com.toshaniFintech.common.exception.model.NotFoundException;
import com.toshaniFintech.common.exception.model.UnprocessableEntityException;
import com.toshaniFintech.user_service.entity.ApiPartnerServiceEntity;
import com.toshaniFintech.user_service.entity.TicketMessagesEntity;
import com.toshaniFintech.user_service.model.ApiPartnerServiceModel;
import com.toshaniFintech.user_service.model.TicketMessagesModel;
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
    private ApiPartnerServicesRepository apiPartnerServicesRepository;

    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public List<ApiPartnerServiceModel> getAllApiPartnerServices() {
        List<ApiPartnerServiceEntity> apiPartnerServiceEntityList = apiPartnerServicesRepository.findAll();
        return apiPartnerServiceEntityList.stream().map(apiPartnerServiceEntity -> objectMapper.convertValue(apiPartnerServiceEntity, ApiPartnerServiceModel.class)).toList();
    }

    @Override
    public ApiPartnerServiceModel createApisPartnerService(ApiPartnerServiceModel apiPartnerServiceModel) {
        ApiPartnerServiceEntity apiPartnerServiceEntity = objectMapper.convertValue(apiPartnerServiceModel, ApiPartnerServiceEntity.class);
        TicketMessagesEntity saved = apiPartnerServicesRepository.save(apiPartnerServiceEntity);
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
