package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.RemittanceChargeCommissionGetRequest;
import com.toshaniFintech.user_service.dto.response.RemittanceChargeCommissionResponse;
import com.toshaniFintech.user_service.entity.RemittanceChargeCommissionEntity;
import com.toshaniFintech.user_service.mapper.RemittanceChargeCommissionMapper;
import com.toshaniFintech.user_service.model.RemittanceChargeCommissionModel;
import com.toshaniFintech.user_service.repository.RemittanceChargeCommissionRepository;
import com.toshaniFintech.user_service.service.RemittanceChargeCommissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RemittanceChargeCommissionServiceImpl implements RemittanceChargeCommissionService {
    @Autowired
    private RemittanceChargeCommissionRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RemittanceChargeCommissionMapper remittanceChargeCommissionMapper;

    @Override
    public RemittanceChargeCommissionModel create(RemittanceChargeCommissionModel model) {
        RemittanceChargeCommissionEntity entity =
                objectMapper.convertValue(model, RemittanceChargeCommissionEntity.class);

        RemittanceChargeCommissionEntity saved = repository.save(entity);

        return objectMapper.convertValue(saved, RemittanceChargeCommissionModel.class);
    }

    @Override
    public PaginatedResponse<RemittanceChargeCommissionResponse> fetchRemittanceChargeCommission(
            RemittanceChargeCommissionGetRequest request) {

        PageRequest page = Utility.pageRequest(
                request.getPageNo(),
                request.getPageSize(),
                request.getSortBy(),
                request.getOrderBy()
        );

        Page<RemittanceChargeCommissionEntity> paginatedContent =
                repository.fetchRemittanceChargeCommission(
                        request.getSearch(),
                        request.getSearchByField(),
                        page
                );

        List<RemittanceChargeCommissionResponse> response = new ArrayList<>();
        paginatedContent.getContent().forEach(content ->
                response.add(remittanceChargeCommissionMapper.toResponse(content))
        );

        return Utility.paginatedResponseForSubList(
                paginatedContent.getNumber(),
                paginatedContent.getTotalPages(),
                paginatedContent.getSize(),
                paginatedContent.getNumberOfElements(),
                paginatedContent.getTotalElements(),
                response
        );
    }
    @Override
    public RemittanceChargeCommissionResponse getById(String id) {

        RemittanceChargeCommissionEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Remittance Charge not found with id: " + id));

        return remittanceChargeCommissionMapper.toResponse(entity);
    }
    @Override
    public RemittanceChargeCommissionResponse update(String id, RemittanceChargeCommissionModel model) {

        RemittanceChargeCommissionEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Remittance Charge not found with id: " + id));

        entity.setMinAmount(model.getMinAmount());
        entity.setMaxAmount(model.getMaxAmount());
        entity.setChargeType(model.getChargeType());
        entity.setCharge(model.getCharge());

        RemittanceChargeCommissionEntity updatedEntity = repository.save(entity);

        return remittanceChargeCommissionMapper.toResponse(updatedEntity);
    }
    @Override
    public void delete(String id) {

        RemittanceChargeCommissionEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Remittance Charge not found with id: " + id));

        repository.delete(entity);
    }
}
