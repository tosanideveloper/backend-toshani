package com.toshaniFintech.settlement.service.impl;

import com.toshaniFintech.settlement.dto.request.GenerateBalanceHistoryRequest;
import com.toshaniFintech.settlement.dto.response.WalletBalanceHistoryResponse;
import com.toshaniFintech.settlement.entity.WalletBalanceHistory;
import com.toshaniFintech.settlement.repository.WalletBalanceHistoryRepository;
import com.toshaniFintech.settlement.repository.WalletMasterRepository;
import com.toshaniFintech.settlement.service.WalletBalanceHistoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class WalletBalanceHistoryServiceImpl implements WalletBalanceHistoryService {

    @Autowired
    private WalletBalanceHistoryRepository historyRepository;

    @Autowired
    private WalletMasterRepository walletRepository;

    @Override
    public List<WalletBalanceHistoryResponse> getHistoryByUser(String userUuid) {
        return historyRepository.findByUserUuidOrderByDateDesc(userUuid)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<WalletBalanceHistoryResponse> getHistoryByDate(LocalDate date) {
        return historyRepository.findByDate(date)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<WalletBalanceHistoryResponse> getHistoryByUserAndDateRange(String userUuid, LocalDate from, LocalDate to) {
        return historyRepository.findByUserUuidAndDateBetweenOrderByDateAsc(userUuid, from, to)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    /**
     * Computes EOD snapshot for the given date for one or all users.
     * BOD for the given date = EOD of the previous day's snapshot.
     * Called by admin trigger or cron job.
     */
    @Override
    @Transactional
    public List<WalletBalanceHistoryResponse> generateDailySnapshot(GenerateBalanceHistoryRequest request) {
        LocalDate date = request.getDate();

        // Get distinct user UUIDs to snapshot
        List<String> userUuids;
        if (request.getUserUuid() != null) {
            userUuids = List.of(request.getUserUuid());
        } else {
            // Collect all distinct users from wallet master
            userUuids = walletRepository.findAll()
                    .stream()
                    .map(w -> w.getUserUuid())
                    .distinct()
                    .collect(Collectors.toList());
        }

        List<WalletBalanceHistory> snapshots = userUuids.stream().map(userUuid -> {
            // BOD = EOD from previous day's snapshot
            BigDecimal bod = historyRepository
                    .findByUserUuidAndDate(userUuid, date.minusDays(1))
                    .map(WalletBalanceHistory::getEodBalance)
                    .orElse(BigDecimal.ZERO);

            BigDecimal eligibleBod = historyRepository
                    .findByUserUuidAndDate(userUuid, date.minusDays(1))
                    .map(WalletBalanceHistory::getEligibleEod)
                    .orElse(BigDecimal.ZERO);

            // Day totals from wallet transactions on this date
            List<com.toshaniFintech.settlement.entity.WalletMaster> dayTxns =
                    walletRepository.findByUserUuidAndTransactionDateBetween(userUuid, date, date);

            BigDecimal totalCredit = dayTxns.stream()
                    .filter(w -> w.getTransactionType() == com.toshaniFintech.settlement.enums.WalletTransactionType.CREDIT)
                    .map(w -> w.getTransactionAmount())
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            BigDecimal totalDebit = dayTxns.stream()
                    .filter(w -> w.getTransactionType() == com.toshaniFintech.settlement.enums.WalletTransactionType.DEBIT)
                    .map(w -> w.getTransactionAmount())
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            BigDecimal eod = bod.add(totalCredit).subtract(totalDebit);

            BigDecimal eligibleEod = walletRepository.calculateEligibleCashoutBalance(userUuid, date);

            // Upsert: update existing record if it already exists for this date
            WalletBalanceHistory history = historyRepository
                    .findByUserUuidAndDate(userUuid, date)
                    .orElse(new WalletBalanceHistory());

            history.setUuid(history.getUuid() == null ? UUID.randomUUID().toString() : history.getUuid());
            history.setUserUuid(userUuid);
            history.setDate(date);
            history.setBodBalance(bod);
            history.setEodBalance(eod);
            history.setTotalCreditAmount(totalCredit);
            history.setTotalDebitAmount(totalDebit);
            history.setEligibleBod(eligibleBod);
            history.setEligibleEod(eligibleEod);

            return historyRepository.save(history);
        }).collect(Collectors.toList());

        log.info("Generated daily snapshot for {} users on date {}", snapshots.size(), date);
        return snapshots.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    private WalletBalanceHistoryResponse mapToResponse(WalletBalanceHistory entity) {
        WalletBalanceHistoryResponse response = new WalletBalanceHistoryResponse();
        response.setId(entity.getId());
        response.setUuid(entity.getUuid());
        response.setUserUuid(entity.getUserUuid());
        response.setDate(entity.getDate());
        response.setBodBalance(entity.getBodBalance());
        response.setEodBalance(entity.getEodBalance());
        response.setTotalDebitAmount(entity.getTotalDebitAmount());
        response.setTotalCreditAmount(entity.getTotalCreditAmount());
        response.setEligibleBod(entity.getEligibleBod());
        response.setEligibleEod(entity.getEligibleEod());
        return response;
    }
}