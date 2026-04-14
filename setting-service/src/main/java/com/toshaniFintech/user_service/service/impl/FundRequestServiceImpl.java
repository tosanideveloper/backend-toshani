package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.exception.model.NotFoundException;
import com.toshaniFintech.user_service.dto.request.FundRequestRequest;
import com.toshaniFintech.user_service.dto.response.FundRequestResponse;
import com.toshaniFintech.user_service.entity.FundRequestEntity;
import com.toshaniFintech.user_service.repository.FundRequestRepository;
import com.toshaniFintech.user_service.service.FundRequestService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FundRequestServiceImpl implements FundRequestService {

    @Autowired
    private FundRequestRepository fundRequestRepository;

    @Override
    public List<FundRequestResponse> getAllFundRequests() {
        List<FundRequestEntity> fundRequests = fundRequestRepository.findAll();

        return fundRequests.stream()
                .map(this::mapToModel)
                .collect(Collectors.toList());
    }

    @Override
    public FundRequestResponse updateFundRequest(String id, @NotNull FundRequestRequest fundRequestRequest) {
        FundRequestEntity existingEntity = fundRequestRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("FundRequest not found with id: " + id));

        existingEntity.setRequestId(fundRequestRequest.getRequestId());
        existingEntity.setPartnerId(fundRequestRequest.getPartnerId());
        existingEntity.setCompanyName(fundRequestRequest.getCompanyName());
        existingEntity.setBankName(fundRequestRequest.getBankName());
        existingEntity.setAccountNo(fundRequestRequest.getAccountNo());
        existingEntity.setIfscCode(fundRequestRequest.getIfscCode());
        existingEntity.setImage(fundRequestRequest.getImage());

        FundRequestEntity updatedEntity = fundRequestRepository.save(existingEntity);

        return mapToModel(updatedEntity);
    }

    private FundRequestResponse mapToModel(FundRequestEntity entity) {
        FundRequestResponse response = new FundRequestResponse();
        response.setId(entity.getId());
        response.setRequestId(entity.getRequestId());
        response.setPartnerId(entity.getPartnerId());
        response.setCompanyName(entity.getCompanyName());
        response.setBankName(entity.getBankName());
        response.setAccountNo(entity.getAccountNo());
        response.setIfscCode(entity.getIfscCode());
        response.setImage(entity.getImage());
        return response;
    }
}