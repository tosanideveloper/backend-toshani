package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.PayoutChargeCommissionGetRequest;
import com.toshaniFintech.user_service.dto.response.PayoutChargeCommissionResponse;
import com.toshaniFintech.user_service.entity.PayoutChargeCommissionEntity;
import com.toshaniFintech.user_service.mapper.PayoutChargeCommissionMapper;
import com.toshaniFintech.user_service.model.PayoutChargeCommissionModel;
import com.toshaniFintech.user_service.repository.PayoutChargeCommissionRepository;
import com.toshaniFintech.user_service.service.PayoutChargeCommissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PayoutChargeCommissionServiceImpl implements PayoutChargeCommissionService {
    @Autowired
    private PayoutChargeCommissionRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PayoutChargeCommissionMapper payoutChargeCommissionMapper;

    @Override
    public PayoutChargeCommissionModel create(PayoutChargeCommissionModel model) {
        PayoutChargeCommissionEntity entity =
                objectMapper.convertValue(model, PayoutChargeCommissionEntity.class);

        PayoutChargeCommissionEntity saved = repository.save(entity);

        return objectMapper.convertValue(saved, PayoutChargeCommissionModel.class);
    }

    @Override
    public PaginatedResponse<PayoutChargeCommissionResponse> fetchPayoutChargeCommission(
            PayoutChargeCommissionGetRequest request) {

        PageRequest page = Utility.pageRequest(
                request.getPageNo(),
                request.getPageSize(),
                request.getSortBy(),
                request.getOrderBy()
        );

        Page<PayoutChargeCommissionEntity> paginatedContent =
                repository.fetchPayoutChargeCommission(
                        request.getSearch(),
                        request.getSearchByField(),
                        page
                );

        List<PayoutChargeCommissionResponse> response = new ArrayList<>();
        paginatedContent.getContent().forEach(content ->
                response.add(payoutChargeCommissionMapper.toResponse(content))
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
    public PayoutChargeCommissionResponse getById(String id) {

        PayoutChargeCommissionEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payout Charge not found with id: " + id));

        return payoutChargeCommissionMapper.toResponse(entity);
    }
    @Override
    public PayoutChargeCommissionResponse update(String id, PayoutChargeCommissionModel model) {

        PayoutChargeCommissionEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payout Charge not found with id: " + id));

        entity.setMinAmount(model.getMinAmount());
        entity.setMaxAmount(model.getMaxAmount());
        entity.setTxnType(model.getTxnType());
        entity.setChargeType(model.getChargeType());
        entity.setCharge(model.getCharge());

        PayoutChargeCommissionEntity updatedEntity = repository.save(entity);

        return payoutChargeCommissionMapper.toResponse(updatedEntity);
    }
    @Override
    public void delete(String id) {

        PayoutChargeCommissionEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payout Charge not found with id: " + id));

        repository.delete(entity);
    }
}

