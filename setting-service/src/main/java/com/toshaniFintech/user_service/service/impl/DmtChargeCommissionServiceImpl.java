package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.DmtChargeCommissionGetRequest;
import com.toshaniFintech.user_service.dto.response.DmtChargeCommissionResponse;
import com.toshaniFintech.user_service.entity.DmtChargeCommissionEntity;
import com.toshaniFintech.user_service.mapper.DmtChargeCommissionMapper;
import com.toshaniFintech.user_service.model.DmtChargeCommissionModel;
import com.toshaniFintech.user_service.repository.DmtChargeCommissionRepository;
import com.toshaniFintech.user_service.service.DmtChargeCommissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DmtChargeCommissionServiceImpl implements DmtChargeCommissionService {
    @Autowired
    private DmtChargeCommissionRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private DmtChargeCommissionMapper dmtChargeCommissionMapper;

    @Override
    public DmtChargeCommissionModel create(DmtChargeCommissionModel model) {
        DmtChargeCommissionEntity entity =
                objectMapper.convertValue(model, DmtChargeCommissionEntity.class);

        DmtChargeCommissionEntity saved = repository.save(entity);

        return objectMapper.convertValue(saved, DmtChargeCommissionModel.class);
    }

    @Override
    public PaginatedResponse<DmtChargeCommissionResponse> fetchDmtChargeCommission(
            DmtChargeCommissionGetRequest request) {

        PageRequest page = Utility.pageRequest(
                request.getPageNo(),
                request.getPageSize(),
                request.getSortBy(),
                request.getOrderBy()
        );

        Page<DmtChargeCommissionEntity> paginatedContent =
                repository.fetchDmtChargeCommission(
                        request.getSearch(),
                        request.getSearchByField(),
                        page
                );

        List<DmtChargeCommissionResponse> response = new ArrayList<>();
        paginatedContent.getContent().forEach(content ->
                response.add(dmtChargeCommissionMapper.toResponse(content))
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
    public DmtChargeCommissionResponse getById(String id) {

        DmtChargeCommissionEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dmt Charge not found with id: " + id));

        return dmtChargeCommissionMapper.toResponse(entity);
    }
    @Override
    public DmtChargeCommissionResponse update(String id, DmtChargeCommissionModel model) {

        DmtChargeCommissionEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dmt Charge not found with id: " + id));

        entity.setMinAmount(model.getMinAmount());
        entity.setMaxAmount(model.getMaxAmount());
        entity.setCommType(model.getCommType());
        entity.setComm(model.getComm());

        DmtChargeCommissionEntity updatedEntity = repository.save(entity);

        return dmtChargeCommissionMapper.toResponse(updatedEntity);
    }
    @Override
    public void delete(String id) {

        DmtChargeCommissionEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dmt Charge not found with id: " + id));

        repository.delete(entity);
    }
}
