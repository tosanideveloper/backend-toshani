package com.toshaniFintech.settlement.service;

import com.toshaniFintech.settlement.dto.request.GenerateBalanceHistoryRequest;
import com.toshaniFintech.settlement.dto.response.WalletBalanceHistoryResponse;

import java.time.LocalDate;
import java.util.List;

public interface WalletBalanceHistoryService {

    List<WalletBalanceHistoryResponse> getHistoryByUser(String userUuid);

    List<WalletBalanceHistoryResponse> getHistoryByDate(LocalDate date);

    List<WalletBalanceHistoryResponse> getHistoryByUserAndDateRange(String userUuid, LocalDate from, LocalDate to);

    // Admin/cron trigger: computes and saves BOD/EOD snapshot for the given date
    List<WalletBalanceHistoryResponse> generateDailySnapshot(GenerateBalanceHistoryRequest request);
}
