package com.toshaniFintech.user_service.controller;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.PayoutReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.PayoutReportResponseDTO;
import com.toshaniFintech.user_service.service.PayoutReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/payout-report")
@Tag(name = "Payout Report API", description = "APIs for Payout Report")
public class PayoutReportController {

    @Autowired
    private PayoutReportService service;

    @PostMapping("/all")
    @Operation(summary = "Payout Report", description = "Get payout report with pagination and advanced filter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Report fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<PaginatedResponse<PayoutReportResponseDTO>> fetchPayoutReport(
            @Valid @RequestBody PayoutReportRequestDTO requestDTO) {

        return new ResponseEntity<>(service.fetchPayoutReport(requestDTO), HttpStatus.OK);
    }
}