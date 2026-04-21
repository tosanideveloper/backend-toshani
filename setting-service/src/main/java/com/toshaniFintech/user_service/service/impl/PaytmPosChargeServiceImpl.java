package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.PaytmPosChargeRequestDTO;
import com.toshaniFintech.user_service.dto.response.PaytmPosChargeResponseDTO;
import com.toshaniFintech.user_service.entity.PaytmPosChargeEntity;
import com.toshaniFintech.user_service.mapper.PaytmPosChargeMapper;
import com.toshaniFintech.user_service.model.PaytmPosChargeModel;
import com.toshaniFintech.user_service.repository.PaytmPosChargeRepository;
import com.toshaniFintech.user_service.service.PaytmPosChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaytmPosChargeServiceImpl implements PaytmPosChargeService {

    @Autowired
    private PaytmPosChargeRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PaytmPosChargeMapper mapper;

    @Override
    public PaytmPosChargeModel create(PaytmPosChargeModel model) {

        PaytmPosChargeEntity entity =
                objectMapper.convertValue(model, PaytmPosChargeEntity.class);

        PaytmPosChargeEntity saved = repository.save(entity);

        return objectMapper.convertValue(saved, PaytmPosChargeModel.class);
    }

    @Override
    public PaginatedResponse<PaytmPosChargeResponseDTO> getAll(
            PaytmPosChargeRequestDTO requestDTO) {

        PageRequest page = Utility.pageRequest(
                requestDTO.getPageNo(),
                requestDTO.getPageSize(),
                requestDTO.getSortBy(),
                requestDTO.getOrderBy()
        );

        Page<PaytmPosChargeEntity> paginatedContent =
                repository.fetchAll(
                        requestDTO.getPaymentMode(),
                        requestDTO.getChargeType(),
                        requestDTO.getMinAmount(),
                        requestDTO.getMaxAmount(),
                        requestDTO.getSearch(),
                        requestDTO.getSearchByField(),
                        page
                );

        List<PaytmPosChargeResponseDTO> responseDTOS = new ArrayList<>();
        paginatedContent.getContent().forEach(content ->
                responseDTOS.add(mapper.toResponseDto(content))
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
    public PaytmPosChargeResponseDTO getById(String id) {

        PaytmPosChargeEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Charge not found with id: " + id));

        return mapper.toResponseDto(entity);
    }

    @Override
    public PaytmPosChargeResponseDTO update(String id, PaytmPosChargeModel model) {

        PaytmPosChargeEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Charge not found with id: " + id));

        entity.setMinAmount(model.getMinAmount());
        entity.setMaxAmount(model.getMaxAmount());
        entity.setPaymentMode(model.getPaymentMode());
        entity.setChargeType(model.getChargeType());
        entity.setCharge(model.getCharge());

        PaytmPosChargeEntity updatedEntity = repository.save(entity);

        return mapper.toResponseDto(updatedEntity);
    }

    @Override
    public void delete(String id) {

        PaytmPosChargeEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Charge not found with id: " + id));

        repository.delete(entity);
    }
}