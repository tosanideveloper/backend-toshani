package com.toshaniFintech.settlement.controller;

import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.AppConstant;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.settlement.dto.request.WalletCreditRequest;
import com.toshaniFintech.settlement.dto.request.WalletDebitRequest;
import com.toshaniFintech.settlement.dto.request.WalletTransactionFilterRequest;
import com.toshaniFintech.settlement.dto.response.WalletBalanceResponse;
import com.toshaniFintech.settlement.dto.response.WalletTransactionResponse;
import com.toshaniFintech.settlement.service.WalletService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/wallet")
@Tag(name = "Wallet API", description = "APIs for wallet ledger (wallet_master): credit, debit, balance, and transaction history")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @Operation(summary = "Credit wallet", description = "Records an incoming credit entry (e.g., AEPS cashout received). eligible_settlement_date must be computed by caller based on product settlement_day.")
    @PostMapping("/credit")
    public ResponseEntity<APIResponse<WalletTransactionResponse>> creditWallet(
            @Valid @RequestBody WalletCreditRequest request) {
        return ResponseUtil.success(
                "Wallet credited successfully",
                walletService.creditWallet(request),
                HttpStatus.CREATED
        );
    }

    @Operation(summary = "Debit wallet", description = "Records a debit entry (settlement payout, charge deduction). Validates eligible cashout balance before deducting.")
    @PostMapping("/debit")
    public ResponseEntity<APIResponse<WalletTransactionResponse>> debitWallet(
            @Valid @RequestBody WalletDebitRequest request) {
        return ResponseUtil.success(
                "Wallet debited successfully",
                walletService.debitWallet(request),
                HttpStatus.CREATED
        );
    }

    @Operation(summary = "Get all wallet transactions (paginated)")
    @GetMapping("/all")
    public ResponseEntity<APIResponse<PaginatedResponse<WalletTransactionResponse>>> getAllTransactions(
            @RequestParam(name = AppConstant.PAGE_NUMBER_PROPERTY_NAME, defaultValue = AppConstant.PAGE_NUMBER_DEFAULT_VALUE, required = false) int pageNo,
            @RequestParam(name = AppConstant.PAGE_SIZE_PROPERTY_NAME, defaultValue = AppConstant.PAGE_SIZE_DEFAULT_VALUE, required = false) int pageSize,
            @RequestParam(name = AppConstant.SORT_BY_PROPERTY_NAME, defaultValue = AppConstant.SORT_BY_DEFAULT_VALUE, required = false) String sortBy,
            @RequestParam(name = AppConstant.ORDER_TYPE_PROPERTY_NAME, defaultValue = AppConstant.ORDER_TYPE_DEFAULT_VALUE, required = false) String orderType) {
        return ResponseUtil.success(
                "Wallet transactions fetched successfully",
                walletService.getAllTransactions(pageNo, pageSize, sortBy, orderType),
                HttpStatus.OK
        );
    }

    @Operation(summary = "Get wallet transaction by ID")
    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<WalletTransactionResponse>> getTransactionById(@PathVariable String id) {
        return ResponseUtil.success(
                "Wallet transaction fetched successfully",
                walletService.getTransactionById(id),
                HttpStatus.OK
        );
    }

    @Operation(
            summary = "Get wallet balance",
            description = "Returns both total wallet_balance and eligible_for_cashout_balance for the user"
    )
    @GetMapping("/balance/{userUuid}")
    public ResponseEntity<APIResponse<WalletBalanceResponse>> getWalletBalance(@PathVariable String userUuid) {
        return ResponseUtil.success(
                "Wallet balance fetched successfully",
                walletService.getWalletBalance(userUuid),
                HttpStatus.OK
        );
    }

    @Operation(
            summary = "Get eligible cashout balance only",
            description = "Returns only the amount eligible for cashout: realtimeSettlement=true OR eligibleSettlementDate <= today"
    )
    @GetMapping("/eligible-balance/{userUuid}")
    public ResponseEntity<APIResponse<WalletBalanceResponse>> getEligibleCashoutBalance(@PathVariable String userUuid) {
        return ResponseUtil.success(
                "Eligible cashout balance fetched successfully",
                walletService.getEligibleCashoutBalance(userUuid),
                HttpStatus.OK
        );
    }

    @Operation(summary = "Filter wallet transactions", description = "Supports filters: userUuid, transactionType, transactionRefType, fromDate, toDate with pagination")
    @PostMapping("/transactions")
    public ResponseEntity<APIResponse<PaginatedResponse<WalletTransactionResponse>>> filterTransactions(
            @RequestBody WalletTransactionFilterRequest request) {
        return ResponseUtil.success(
                "Wallet transactions fetched successfully",
                walletService.filterTransactions(request),
                HttpStatus.OK
        );
    }
}