package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.HoldBalanceLogReportRequest;
import com.toshaniFintech.user_service.dto.response.HoldBalanceLogReportResponse;
import com.toshaniFintech.user_service.service.HoldBalanceLogReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/hold-balance-log-report")
@Tag(name="Hold Balance Log Report Service API", description = "API for Manage Hold Balance Log Report Service CRUD")
public class HoldBalanceLogReportController {
    @Autowired
    private HoldBalanceLogReportService holdBalanceLogReportService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/all")
    @Operation(summary = "Hold Balance Log Report",
            description = "Get Hold Balance Log Report with pagination and advanced filter")
    @ApiResponses(value = {@ApiResponse(responseCode = "200",
            description = "Hold Balance Log Report fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<PaginatedResponse<HoldBalanceLogReportResponse>> fetchHoldBalanceLogReport
            (@Valid @RequestBody HoldBalanceLogReportRequest holdBalanceLogReportRequest) {

        return new ResponseEntity<>(holdBalanceLogReportService.fetchHoldBalanceLogReport(holdBalanceLogReportRequest),
                HttpStatus.OK);
    }
}
