package com.toshaniFintech.settlement.controller;

import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.settlement.dto.request.GenerateBalanceHistoryRequest;
import com.toshaniFintech.settlement.dto.response.WalletBalanceHistoryResponse;
import com.toshaniFintech.settlement.service.WalletBalanceHistoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/wallet-history")
@Tag(name = "Wallet Balance History API", description = "APIs for daily BOD/EOD wallet balance snapshots (wallet_balance_history)")
public class WalletBalanceHistoryController {

    @Autowired
    private WalletBalanceHistoryService walletBalanceHistoryService;

    @Operation(summary = "Get balance history by user", description = "Returns all daily snapshots for a user, sorted most recent first")
    @GetMapping("/by-user/{userUuid}")
    public ResponseEntity<APIResponse<List<WalletBalanceHistoryResponse>>> getHistoryByUser(
            @PathVariable String userUuid) {
        return ResponseUtil.success(
                "Wallet balance history fetched successfully",
                walletBalanceHistoryService.getHistoryByUser(userUuid),
                HttpStatus.OK
        );
    }

    @Operation(summary = "Get balance history by date", description = "Returns all users' balance snapshots for the given date")
    @GetMapping("/by-date/{date}")
    public ResponseEntity<APIResponse<List<WalletBalanceHistoryResponse>>> getHistoryByDate(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseUtil.success(
                "Wallet balance history fetched successfully",
                walletBalanceHistoryService.getHistoryByDate(date),
                HttpStatus.OK
        );
    }

    @Operation(summary = "Get balance history by user and date range")
    @GetMapping("/by-user/{userUuid}/range")
    public ResponseEntity<APIResponse<List<WalletBalanceHistoryResponse>>> getHistoryByUserAndDateRange(
            @PathVariable String userUuid,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {
        return ResponseUtil.success(
                "Wallet balance history fetched successfully",
                walletBalanceHistoryService.getHistoryByUserAndDateRange(userUuid, from, to),
                HttpStatus.OK
        );
    }

    @Operation(
            summary = "Generate daily BOD/EOD snapshot",
            description = "Admin/cron trigger to compute and persist the BOD/EOD balance snapshot for a given date. " +
                    "If userUuid is null, generates for all users. " +
                    "BOD = previous day's EOD; EOD = BOD + credits - debits for that date."
    )
    @PostMapping("/generate")
    public ResponseEntity<APIResponse<List<WalletBalanceHistoryResponse>>> generateDailySnapshot(
            @Valid @RequestBody GenerateBalanceHistoryRequest request) {
        return ResponseUtil.success(
                "Daily balance snapshot generated successfully",
                walletBalanceHistoryService.generateDailySnapshot(request),
                HttpStatus.OK
        );
    }
}