package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.exception.model.NotFoundException;
import com.toshaniFintech.user_service.dto.response.ApiAllMerchantResponseDTO;
import com.toshaniFintech.user_service.entity.ApiAllMerchantEntity;
import com.toshaniFintech.user_service.model.ApiAllMerchantModel;
import com.toshaniFintech.user_service.repository.ApiAllMerchantRepository;
import com.toshaniFintech.user_service.service.ApiAllMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiAllMerchantImpl implements ApiAllMerchantService {

    @Autowired
    private ApiAllMerchantRepository apiAllMerchantRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<ApiAllMerchantModel> getAllApiMerchantService() {
        List<ApiAllMerchantEntity> settings = apiAllMerchantRepository.findAll();
        List<ApiAllMerchantModel> siteSettingList = settings.stream().map(apiAllMerchantEntity -> objectMapper.convertValue(apiAllMerchantEntity, ApiAllMerchantModel.class)).toList();
        return siteSettingList;
    }

    @Override
    public ApiAllMerchantModel getByID(String id) {
        ApiAllMerchantEntity apiAllMerchantEntity = apiAllMerchantRepository.findById(id).orElseThrow(() -> new NotFoundException("Merchant not found with id: " + id));
        return mapToModel(apiAllMerchantEntity);
    }

    private ApiAllMerchantModel mapToModel(ApiAllMerchantEntity apiAllMerchantEntity) {
        ApiAllMerchantResponseDTO response = new ApiAllMerchantResponseDTO();
        response.setId(apiAllMerchantEntity.getId());
        response.setMerchant(apiAllMerchantEntity.getMerchant());
        response.setMobile(apiAllMerchantEntity.getMobile());
        response.setEmail(apiAllMerchantEntity.getEmail());
        response.setIsPanVerified(apiAllMerchantEntity.getIsPanVerified());
        response.setIsAadhaarCardVerified(apiAllMerchantEntity.getIsAadhaarCardVerified());
        response.setIsAadhaarNoVerified(apiAllMerchantEntity.getIsAadhaarNoVerified());
        response.setStatus(apiAllMerchantEntity.getStatus());

        return objectMapper.convertValue(apiAllMerchantEntity, ApiAllMerchantModel.class);
    }

    @Override
    public ApiAllMerchantModel updateAllMerchant(String id, ApiAllMerchantModel apiAllMerchantModel) {
        ApiAllMerchantEntity apiAllMerchantEntity = apiAllMerchantRepository.findById(id).orElseThrow(() -> new NotFoundException("Merchant not found with id: " + id));
        apiAllMerchantEntity.setMerchant(apiAllMerchantModel.getMerchant());
        apiAllMerchantEntity.setMobile(apiAllMerchantModel.getMobile());
        apiAllMerchantEntity.setEmail(apiAllMerchantModel.getEmail());
        apiAllMerchantEntity.setIsPanVerified(apiAllMerchantModel.getIsPanVerified());
        apiAllMerchantEntity.setIsAadhaarCardVerified(apiAllMerchantModel.getIsAadhaarCardVerified());
        apiAllMerchantEntity.setIsAadhaarNoVerified(apiAllMerchantModel.getIsAadhaarNoVerified());
        apiAllMerchantEntity.setStatus(apiAllMerchantModel.getStatus());

        ApiAllMerchantEntity saved = apiAllMerchantRepository.save(apiAllMerchantEntity);

        return objectMapper.convertValue(saved, ApiAllMerchantModel.class);
    }
}
