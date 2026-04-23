package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.CreditCardChargeCommissionGetRequestDTO;
import com.toshaniFintech.user_service.dto.response.CreditCardChargeCommissionResponseDTO;
import com.toshaniFintech.user_service.entity.CreditCardChargeCommissionEntity;
import com.toshaniFintech.user_service.mapper.CreditCardChargeCommissionMapper;
import com.toshaniFintech.user_service.model.CreditCardChargeCommissionModel;
import com.toshaniFintech.user_service.repository.CreditCardChargeCommissionRepository;
import com.toshaniFintech.user_service.service.CreditCardChargeCommissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreditCardChargeCommissionServiceImpl implements CreditCardChargeCommissionService {

    @Autowired
    private CreditCardChargeCommissionRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CreditCardChargeCommissionMapper creditCardChargeCommissionMapper;

    @Override
    public CreditCardChargeCommissionModel create(CreditCardChargeCommissionModel model) {
        CreditCardChargeCommissionEntity entity =
                objectMapper.convertValue(model, CreditCardChargeCommissionEntity.class);

        CreditCardChargeCommissionEntity saved = repository.save(entity);

        return objectMapper.convertValue(saved, CreditCardChargeCommissionModel.class);
    }

    @Override
    public PaginatedResponse<CreditCardChargeCommissionResponseDTO> fetchCreditCardChargeCommission(
            CreditCardChargeCommissionGetRequestDTO requestDTO) {

        PageRequest page = Utility.pageRequest(
                requestDTO.getPageNo(),
                requestDTO.getPageSize(),
                requestDTO.getSortBy(),
                requestDTO.getOrderBy()
        );

        Page<CreditCardChargeCommissionEntity> paginatedContent =
                repository.fetchCreditCardChargeCommission(
                        requestDTO.getSearch(),
                        requestDTO.getSearchByField(),
                        page
                );

        List<CreditCardChargeCommissionResponseDTO> responseDTOS = new ArrayList<>();
        paginatedContent.getContent().forEach(content ->
                responseDTOS.add(creditCardChargeCommissionMapper.toResponseDto(content))
        );

        return Utility.paginatedResponseForSubList(
                paginatedContent.getNumber(),
                paginatedContent.getTotalPages(),
                paginatedContent.getSize(),
                paginatedContent.getNumberOfElements(),
                paginatedContent.getTotalElements(),
                responseDTOS
        );
    }
    @Override
    public CreditCardChargeCommissionResponseDTO getById(String id) {

        CreditCardChargeCommissionEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Credit Charge not found with id: " + id));

        return creditCardChargeCommissionMapper.toResponseDto(entity);
    }
    @Override
    public CreditCardChargeCommissionResponseDTO update(String id, CreditCardChargeCommissionModel model) {

        CreditCardChargeCommissionEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Credit Charge not found with id: " + id));

        entity.setMinAmount(model.getMinAmount());
        entity.setMaxAmount(model.getMaxAmount());
        entity.setChargeType(model.getChargeType());
        entity.setCharge(model.getCharge());

        CreditCardChargeCommissionEntity updatedEntity = repository.save(entity);

        return creditCardChargeCommissionMapper.toResponseDto(updatedEntity);
    }
    @Override
    public void delete(String id) {

        CreditCardChargeCommissionEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Credit Charge not found with id: " + id));

        repository.delete(entity);
    }
}