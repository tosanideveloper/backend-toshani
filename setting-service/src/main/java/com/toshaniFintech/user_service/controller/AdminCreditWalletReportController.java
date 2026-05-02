package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.AdminCreditWalletReportRequest;
import com.toshaniFintech.user_service.dto.response.AdminCreditWalletReportResponse;
import com.toshaniFintech.user_service.service.AdminCreditWalletReportService;
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
@RequestMapping("api/v1/admin-Credit-wallet-report")
@Tag(name = "Admin Credit Wallet Report Service API", description = "APIs for Manage Admin Credit Wallet Report Service CRUD")
public class AdminCreditWalletReportController {
    @Autowired
    private AdminCreditWalletReportService adminCreditWalletReportService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/all")
    @Operation(summary = "Admin Credit Wallet Report",
            description = "Get Admin Credit Wallet Report with pagination and advanced filter")
    @ApiResponses(value = {@ApiResponse(responseCode = "200",
            description = "Admin Credit Wallet Report fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<PaginatedResponse<AdminCreditWalletReportResponse>> fetchAdminCreditWalletReport
            (@Valid @RequestBody AdminCreditWalletReportRequest adminCreditWalletReportRequest) {

        return new ResponseEntity<>(adminCreditWalletReportService.fetchAdminCreditWalletReport
                (adminCreditWalletReportRequest), HttpStatus.OK);
    }
}
