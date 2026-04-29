package com.toshaniFintech.settlement.service.impl;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.exception.model.BadRequestException;
import com.toshaniFintech.common.exception.model.NotFoundException;
import com.toshaniFintech.settlement.dto.request.WalletCreditRequest;
import com.toshaniFintech.settlement.dto.request.WalletDebitRequest;
import com.toshaniFintech.settlement.dto.request.WalletTransactionFilterRequest;
import com.toshaniFintech.settlement.dto.response.WalletBalanceResponse;
import com.toshaniFintech.settlement.dto.response.WalletTransactionResponse;
import com.toshaniFintech.settlement.entity.WalletMaster;
import com.toshaniFintech.settlement.enums.WalletTransactionType;
import com.toshaniFintech.settlement.repository.WalletMasterRepository;
import com.toshaniFintech.settlement.service.WalletService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletMasterRepository walletRepository;

    @Override
    @Transactional
    public WalletTransactionResponse creditWallet(WalletCreditRequest request) {
        WalletMaster wallet = new WalletMaster();
        wallet.setWalletUuid(UUID.randomUUID().toString());
        wallet.setWalletTransactionId(generateWalletTxnId());
        wallet.setUserUuid(request.getUserUuid());
        wallet.setTransactionAmount(request.getTransactionAmount());
        wallet.setSettlementAmount(request.getSettlementAmount());
        wallet.setTransactionType(WalletTransactionType.CREDIT);
        wallet.setTransactionRefType(request.getTransactionRefType());
        wallet.setTransactionRefId(request.getTransactionRefId());
        wallet.setTransactionDate(request.getTransactionDate());
        wallet.setEligibleSettlementDate(request.getEligibleSettlementDate());
        wallet.setEligibleSettlementDateUpdated(request.getEligibleSettlementDate());
        wallet.setRealtimeSettlement(request.getRealtimeSettlement());
        wallet.setStatus("Completed");
        wallet.setGst(request.getGst());
        wallet.setCgst(request.getCgst());
        wallet.setSgst(request.getSgst());
        wallet.setTds(request.getTds());

        WalletMaster saved = walletRepository.save(wallet);
        log.info("Wallet credited for user {}: amount={}", request.getUserUuid(), request.getTransactionAmount());
        return mapToResponse(saved);
    }

    @Override
    @Transactional
    public WalletTransactionResponse debitWallet(WalletDebitRequest request) {
        // Prevent debit if insufficient eligible balance
        BigDecimal eligibleBalance = walletRepository.calculateEligibleCashoutBalance(
                request.getUserUuid(), LocalDate.now());
        if (eligibleBalance.compareTo(request.getTransactionAmount()) < 0) {
            throw new BadRequestException("Insufficient eligible cashout balance for debit");
        }

        WalletMaster wallet = new WalletMaster();
        wallet.setWalletUuid(UUID.randomUUID().toString());
        wallet.setWalletTransactionId(generateWalletTxnId());
        wallet.setUserUuid(request.getUserUuid());
        wallet.setTransactionAmount(request.getTransactionAmount());
        wallet.setSettlementAmount(BigDecimal.ZERO);
        wallet.setTransactionType(WalletTransactionType.DEBIT);
        wallet.setTransactionRefType(request.getTransactionRefType());
        wallet.setTransactionRefId(request.getTransactionRefId());
        wallet.setTransactionDate(request.getTransactionDate());
        wallet.setStatus("Completed");

        WalletMaster saved = walletRepository.save(wallet);
        log.info("Wallet debited for user {}: amount={}", request.getUserUuid(), request.getTransactionAmount());
        return mapToResponse(saved);
    }

    @Override
    public PaginatedResponse<WalletTransactionResponse> getAllTransactions(int pageNo, int pageSize, String sortBy, String orderType) {
        Sort sort = "ASC".equalsIgnoreCase(orderType)
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Page<WalletMaster> page = walletRepository.findAll(PageRequest.of(pageNo, pageSize, sort));
        PaginatedResponse<WalletTransactionResponse> response = new PaginatedResponse<>(page);
        response.setContent(page.getContent().stream().map(this::mapToResponse).collect(Collectors.toList()));
        return response;
    }

    @Override
    public WalletTransactionResponse getTransactionById(String id) {
        WalletMaster wallet = walletRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Wallet transaction not found with id: " + id));
        return mapToResponse(wallet);
    }

    @Override
    public WalletBalanceResponse getWalletBalance(String userUuid) {
        BigDecimal balance = walletRepository.calculateWalletBalance(userUuid);
        BigDecimal eligibleBalance = walletRepository.calculateEligibleCashoutBalance(userUuid, LocalDate.now());

        return WalletBalanceResponse.builder()
                .userUuid(userUuid)
                .walletBalance(balance)
                .eligibleCashoutBalance(eligibleBalance)
                .build();
    }

    @Override
    public WalletBalanceResponse getEligibleCashoutBalance(String userUuid) {
        BigDecimal eligibleBalance = walletRepository.calculateEligibleCashoutBalance(userUuid, LocalDate.now());

        return WalletBalanceResponse.builder()
                .userUuid(userUuid)
                .walletBalance(null)
                .eligibleCashoutBalance(eligibleBalance)
                .build();
    }

    @Override
    public PaginatedResponse<WalletTransactionResponse> filterTransactions(WalletTransactionFilterRequest request) {
        Sort sort = "ASC".equalsIgnoreCase(request.getOrderType())
                ? Sort.by(request.getSortBy()).ascending()
                : Sort.by(request.getSortBy()).descending();

        Page<WalletMaster> page = walletRepository.findAll(PageRequest.of(request.getPageNo(), request.getPageSize(), sort));

        List<WalletTransactionResponse> filtered = page.getContent().stream()
                .filter(w -> request.getUserUuid() == null || w.getUserUuid().equals(request.getUserUuid()))
                .filter(w -> request.getTransactionType() == null || w.getTransactionType() == request.getTransactionType())
                .filter(w -> request.getTransactionRefType() == null || w.getTransactionRefType() == request.getTransactionRefType())
                .filter(w -> {
                    if (request.getFromDate() == null && request.getToDate() == null) return true;
                    LocalDate date = w.getTransactionDate();
                    if (date == null) return false;
                    if (request.getFromDate() != null && date.isBefore(request.getFromDate())) return false;
                    if (request.getToDate() != null && date.isAfter(request.getToDate())) return false;
                    return true;
                })
                .map(this::mapToResponse)
                .collect(Collectors.toList());

        PaginatedResponse<WalletTransactionResponse> response = new PaginatedResponse<>(page);
        response.setContent(filtered);
        return response;
    }

    // Uses UUID prefix to keep transaction IDs unique and traceable
    private String generateWalletTxnId() {
        return "WTX" + UUID.randomUUID().toString().replace("-", "").substring(0, 16).toUpperCase();
    }

    private WalletTransactionResponse mapToResponse(WalletMaster entity) {
        WalletTransactionResponse response = new WalletTransactionResponse();
        response.setId(entity.getId());
        response.setWalletUuid(entity.getWalletUuid());
        response.setUserUuid(entity.getUserUuid());
        response.setTransactionAmount(entity.getTransactionAmount());
        response.setWalletTransactionId(entity.getWalletTransactionId());
        response.setTransactionType(entity.getTransactionType());
        response.setTransactionRefId(entity.getTransactionRefId());
        response.setTransactionRefType(entity.getTransactionRefType());
        response.setStatus(entity.getStatus());
        response.setSettlementAmount(entity.getSettlementAmount());
        response.setBankSettlementStatus(entity.getBankSettlementStatus());
        response.setRealtimeSettlement(entity.getRealtimeSettlement());
        response.setTransactionDate(entity.getTransactionDate());
        response.setEligibleSettlementDate(entity.getEligibleSettlementDate());
        response.setEligibleSettlementDateUpdated(entity.getEligibleSettlementDateUpdated());
        response.setGst(entity.getGst());
        response.setCgst(entity.getCgst());
        response.setSgst(entity.getSgst());
        response.setTds(entity.getTds());
        return response;
    }
}