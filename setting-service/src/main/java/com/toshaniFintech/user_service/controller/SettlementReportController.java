package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.Aeps1ReportRequestDTO;
import com.toshaniFintech.user_service.dto.request.SettlementReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.Aeps1ReportResponseDTO;
import com.toshaniFintech.user_service.dto.response.SettlementReportResponseDTO;
import com.toshaniFintech.user_service.service.Aeps1ReportService;
import com.toshaniFintech.user_service.service.SettlementReportService;
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
@RequestMapping("api/v1/settlement-report")
@Tag(name = "Settlement Report API", description = "APIs for Settlement Report ")
public class SettlementReportController {

    @Autowired
    private SettlementReportService settlementReportService;

    @PostMapping("/all")
    @Operation(summary = "Settlement Report", description = "Get Settlement Report with pagination and advanced filter")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Settlement Report fetched successfully"), @ApiResponse(responseCode = "400", description = "Invalid input data"), @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<PaginatedResponse<SettlementReportResponseDTO>> fetchSettlementReport(@Valid @RequestBody SettlementReportRequestDTO settlementReportRequestDTO) {

        return new ResponseEntity<>(settlementReportService.fetchSettlementReport(settlementReportRequestDTO), HttpStatus.OK);
    }
}
