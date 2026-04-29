package com.toshaniFintech.settlement.service.impl;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.exception.model.BadRequestException;
import com.toshaniFintech.common.exception.model.NotFoundException;
import com.toshaniFintech.settlement.dto.request.CreateSettlementRequest;
import com.toshaniFintech.settlement.dto.request.SettlementReportRequest;
import com.toshaniFintech.settlement.dto.request.UpdateSettlementRequest;
import com.toshaniFintech.settlement.dto.response.SettlementResponse;
import com.toshaniFintech.settlement.entity.SettlementMaster;
import com.toshaniFintech.settlement.enums.SettlementStatus;
import com.toshaniFintech.settlement.repository.SettlementMasterRepository;
import com.toshaniFintech.settlement.service.SettlementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SettlementServiceImpl implements SettlementService {

    @Autowired
    private SettlementMasterRepository settlementRepository;

    @Override
    @Transactional
    public SettlementResponse createSettlement(CreateSettlementRequest request) {
        SettlementMaster settlement = new SettlementMaster();
        settlement.setSettlementUuid(UUID.randomUUID().toString());
        settlement.setTransactionId(request.getTransactionId());
        settlement.setUserUuid(request.getUserUuid());
        settlement.setClientRefId(request.getClientRefId());
        settlement.setTransactionAmount(request.getTransactionAmount());
        settlement.setTransactionRefType(request.getTransactionRefType());
        settlement.setTransactionType(request.getTransactionType());
        settlement.setMerchantUuid(request.getMerchantUuid());
        settlement.setUserAccountUuid(request.getUserAccountUuid());
        settlement.setSettlementDate(request.getSettlementDate());
        // New settlement always starts in REQUESTED state
        settlement.setStatus(SettlementStatus.REQUESTED);

        SettlementMaster saved = settlementRepository.save(settlement);
        log.info("Settlement created: {}", saved.getSettlementUuid());
        return mapToResponse(saved);
    }

    @Override
    public PaginatedResponse<SettlementResponse> getAllSettlements(int pageNo, int pageSize, String sortBy, String orderType) {
        Sort sort = "ASC".equalsIgnoreCase(orderType)
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Page<SettlementMaster> page = settlementRepository.findAll(PageRequest.of(pageNo, pageSize, sort));
        PaginatedResponse<SettlementResponse> response = new PaginatedResponse<>(page);
        response.setContent(page.getContent().stream().map(this::mapToResponse).collect(Collectors.toList()));
        return response;
    }

    @Override
    public SettlementResponse getSettlementById(String id) {
        SettlementMaster settlement = settlementRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Settlement not found with id: " + id));
        return mapToResponse(settlement);
    }

    @Override
    @Transactional
    public SettlementResponse updateSettlement(String id, UpdateSettlementRequest request) {
        SettlementMaster settlement = settlementRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Settlement not found with id: " + id));

        // REVERSED is only valid from SUCCESS; prevent invalid state transitions
        if (request.getStatus() == SettlementStatus.REVERSED
                && settlement.getStatus() != SettlementStatus.SUCCESS) {
            throw new BadRequestException("Can only reverse a successful settlement");
        }

        settlement.setStatus(request.getStatus());
        if (request.getRrnBank() != null) {
            settlement.setRrnBank(request.getRrnBank());
        }

        SettlementMaster saved = settlementRepository.save(settlement);
        log.info("Settlement {} status updated to {}", saved.getSettlementUuid(), saved.getStatus());
        return mapToResponse(saved);
    }

    @Override
    public List<SettlementResponse> getSettlementsByUser(String userUuid) {
        return settlementRepository.findByUserUuid(userUuid)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PaginatedResponse<SettlementResponse> getSettlementReport(SettlementReportRequest request) {
        Sort sort = "ASC".equalsIgnoreCase(request.getOrderType())
                ? Sort.by(request.getSortBy()).ascending()
                : Sort.by(request.getSortBy()).descending();

        PageRequest pageRequest = PageRequest.of(request.getPageNo(), request.getPageSize(), sort);

        // Fetch all and apply in-memory filters; replace with JPA Specification for large data sets
        Page<SettlementMaster> page = settlementRepository.findAll(pageRequest);

        List<SettlementResponse> filtered = page.getContent().stream()
                .filter(s -> request.getUserUuid() == null || s.getUserUuid().equals(request.getUserUuid()))
                .filter(s -> request.getStatus() == null || s.getStatus() == request.getStatus())
                .filter(s -> request.getTransactionType() == null || s.getTransactionType() == request.getTransactionType())
                .filter(s -> {
                    if (request.getFromDate() == null && request.getToDate() == null) return true;
                    LocalDate date = s.getSettlementDate();
                    if (date == null) return false;
                    if (request.getFromDate() != null && date.isBefore(request.getFromDate())) return false;
                    if (request.getToDate() != null && date.isAfter(request.getToDate())) return false;
                    return true;
                })
                .map(this::mapToResponse)
                .collect(Collectors.toList());

        PaginatedResponse<SettlementResponse> response = new PaginatedResponse<>(page);
        response.setContent(filtered);
        return response;
    }

    private SettlementResponse mapToResponse(SettlementMaster entity) {
        SettlementResponse response = new SettlementResponse();
        response.setId(entity.getId());
        response.setSettlementUuid(entity.getSettlementUuid());
        response.setTransactionId(entity.getTransactionId());
        response.setUserUuid(entity.getUserUuid());
        response.setRrnBank(entity.getRrnBank());
        response.setClientRefId(entity.getClientRefId());
        response.setTransactionAmount(entity.getTransactionAmount());
        response.setStatus(entity.getStatus());
        response.setTransactionRefType(entity.getTransactionRefType());
        response.setTransactionType(entity.getTransactionType());
        response.setMerchantUuid(entity.getMerchantUuid());
        response.setUserAccountUuid(entity.getUserAccountUuid());
        response.setSettlementDate(entity.getSettlementDate());
        response.setActive(entity.isActive());
        return response;
    }
}