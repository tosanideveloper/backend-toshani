package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.PartnerBalanceReportRequest;
import com.toshaniFintech.user_service.dto.response.PartnerBalanceReportResponse;
import com.toshaniFintech.user_service.service.PartnerBalanceReportService;
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
@RequestMapping("api/v1/partner_balance_report")
@Tag(name="Partner Balance Report Service API", description="API for Manage Partner Balance Report Service CRUD")
public class PartnerBalanceReportController {
    @Autowired
    private PartnerBalanceReportService partnerBalanceReportService;
    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/all")
    @Operation(summary = "Partrner Balance Report",
            description = "Get Partner Balance Report with pagination and advanced filter")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Partner Balance Report fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"), @ApiResponse(responseCode = "500",
            description = "Internal server error")})
    public ResponseEntity<PaginatedResponse<PartnerBalanceReportResponse>> fetchAmcReport
            (@Valid @RequestBody PartnerBalanceReportRequest partnerBalanceReportRequest) {
        return new ResponseEntity<>(partnerBalanceReportService.fetchPartnerBalanceReport
                (partnerBalanceReportRequest), HttpStatus.OK);
    }

}
