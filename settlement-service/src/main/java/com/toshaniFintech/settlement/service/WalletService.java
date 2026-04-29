package com.toshaniFintech.settlement.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.settlement.dto.request.WalletCreditRequest;
import com.toshaniFintech.settlement.dto.request.WalletDebitRequest;
import com.toshaniFintech.settlement.dto.request.WalletTransactionFilterRequest;
import com.toshaniFintech.settlement.dto.response.WalletBalanceResponse;
import com.toshaniFintech.settlement.dto.response.WalletTransactionResponse;

public interface WalletService {

    WalletTransactionResponse creditWallet(WalletCreditRequest request);

    WalletTransactionResponse debitWallet(WalletDebitRequest request);

    PaginatedResponse<WalletTransactionResponse> getAllTransactions(int pageNo, int pageSize, String sortBy, String orderType);

    WalletTransactionResponse getTransactionById(String id);

    WalletBalanceResponse getWalletBalance(String userUuid);

    WalletBalanceResponse getEligibleCashoutBalance(String userUuid);

    PaginatedResponse<WalletTransactionResponse> filterTransactions(WalletTransactionFilterRequest request);
}
