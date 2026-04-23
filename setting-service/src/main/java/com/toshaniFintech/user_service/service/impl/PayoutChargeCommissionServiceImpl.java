package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.exception.model.BadRequestException;
import com.toshaniFintech.common.exception.model.NotFoundException;
import com.toshaniFintech.user_service.dto.request.PayoutChargeCommissionRequest;
import com.toshaniFintech.user_service.dto.response.PayoutChargeCommissionResponse;
import com.toshaniFintech.user_service.entity.PayoutChargeCommissionEntity;
import com.toshaniFintech.user_service.repository.PayoutChargeCommissionRepository;
import com.toshaniFintech.user_service.service.PayoutChargeCommissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
public class PayoutChargeCommissionServiceImpl implements PayoutChargeCommissionService {
    @Autowired
    private PayoutChargeCommissionRepository payoutChargeCommissionRepository;

    @Override
    public PayoutChargeCommissionResponse createPayoutChargeCommission
            (PayoutChargeCommissionRequest payoutChargeCommissionRequest){
        PayoutChargeCommissionEntity entity = mapToEntity(payoutChargeCommissionRequest);
        PayoutChargeCommissionEntity savedEntity = payoutChargeCommissionRepository.save(entity);
        return mapToModel(savedEntity);
    }

    @Override
    public PayoutChargeCommissionResponse getPayoutChargeCommissionById(String id) {
        PayoutChargeCommissionEntity entity = payoutChargeCommissionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Payout Charge Commission Entity not found with id: " + id));
        return mapToModel(entity);
    }

    @Override
    public PayoutChargeCommissionResponse updatePayoutChargeCommission
            (String id, PayoutChargeCommissionRequest payoutChargeCommissionRequest) {
        PayoutChargeCommissionEntity existingEntity = payoutChargeCommissionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Payout Charge Commission not found with id: " + id));

        existingEntity.setMinAmount(payoutChargeCommissionRequest.getMinAmount());
        existingEntity.setMaxAmount(payoutChargeCommissionRequest.getMaxAmount());
        existingEntity.setTxnType(payoutChargeCommissionRequest.getTxnType());
        existingEntity.setChargeType(payoutChargeCommissionRequest.getChargeType());
        existingEntity.setCharge(payoutChargeCommissionRequest.getCharge());

        PayoutChargeCommissionEntity updatedEntity = payoutChargeCommissionRepository.save(existingEntity);
        return mapToModel(updatedEntity);
    }

    @Override
    public PaginatedResponse<PayoutChargeCommissionResponse> getAllPayoutChargeCommission(PageRequest pageRequest) {

        Page<PayoutChargeCommissionEntity> payoutChargeCommissionPage = payoutChargeCommissionRepository.findAll(pageRequest);

        PaginatedResponse<PayoutChargeCommissionResponse> response =
                new PaginatedResponse<>(payoutChargeCommissionPage);

        response.setContent(
                payoutChargeCommissionPage.getContent()
                        .stream()
                        .map(this::mapToModel)
                        .collect(Collectors.toList())
        );

        return response;
    }

    @Override
    public void deletePayoutChargeCommission(String id) {
        PayoutChargeCommissionEntity existingEntity = payoutChargeCommissionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Payout Charge Commission not found with id: " + id));

        if (!existingEntity.isActive()) {
            throw new BadRequestException("Payout Charge Commission already deleted");
        }
        existingEntity.setActive(false);
        existingEntity.setDeletedAt(LocalDateTime.now());
        payoutChargeCommissionRepository.save(existingEntity);
    }
    private PayoutChargeCommissionEntity mapToEntity(PayoutChargeCommissionRequest model) {
        PayoutChargeCommissionEntity entity = new PayoutChargeCommissionEntity();
        entity.setMinAmount(model.getMinAmount());
        entity.setMaxAmount(model.getMaxAmount());
        entity.setTxnType(model.getTxnType());
        entity.setChargeType(model.getChargeType());
        entity.setCharge(model.getCharge());
        return entity;
    }

    private PayoutChargeCommissionResponse mapToModel(PayoutChargeCommissionEntity entity) {
        PayoutChargeCommissionResponse response = new PayoutChargeCommissionResponse();
        response.setId(entity.getId());
        response.setMinAmount(entity.getMinAmount());
        response.setMaxAmount(entity.getMaxAmount());
        response.setTxnType(entity.getTxnType());
        response.setChargeType(entity.getChargeType());
        response.setCharge(entity.getCharge());
        response.setActive(entity.isActive());
        return response;
    }
}

