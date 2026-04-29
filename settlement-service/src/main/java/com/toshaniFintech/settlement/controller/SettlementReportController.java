package com.toshaniFintech.settlement.controller;

import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.settlement.dto.request.SettlementReportRequest;
import com.toshaniFintech.settlement.dto.response.SettlementResponse;
import com.toshaniFintech.settlement.service.SettlementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/settlement-report")
@Tag(name = "Settlement Report API", description = "Filtered settlement report with date range, status, and user filters")
public class SettlementReportController {

    @Autowired
    private SettlementService settlementService;

    @Operation(
            summary = "Get settlement report",
            description = "Filtered paginated settlement report. Supports filter by userUuid, status, transactionType, fromDate, toDate"
    )
    @PostMapping("/get")
    public ResponseEntity<APIResponse<PaginatedResponse<SettlementResponse>>> getSettlementReport(
            @RequestBody SettlementReportRequest request) {
        return ResponseUtil.success(
                "Settlement report fetched successfully",
                settlementService.getSettlementReport(request),
                HttpStatus.OK
        );
    }
}