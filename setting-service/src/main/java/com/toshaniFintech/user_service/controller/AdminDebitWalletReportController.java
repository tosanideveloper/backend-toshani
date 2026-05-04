package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.AdminDebitWalletReportRequest;
import com.toshaniFintech.user_service.dto.response.AdminDebitWalletReportResponse;
import com.toshaniFintech.user_service.service.AdminDebitWalletReportService;
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
@RequestMapping("api/v1/admin-debit-wallet-report")
@Tag(name = "Admin Debit Wallet Report Service API", description = "APIs for Manage Admin Debit Wallet Report Service CRUD")
public class AdminDebitWalletReportController {
    @Autowired
    private AdminDebitWalletReportService adminDebitWalletReportService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/all")
    @Operation(summary = "Admin Debit Wallet Report",
            description = "Get Admin Debit Wallet Report with pagination and advanced filter")
    @ApiResponses(value = {@ApiResponse(responseCode = "200",
            description = "Admin Debit Wallet Report fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<PaginatedResponse<AdminDebitWalletReportResponse>> fetchAdminDebitWalletReport
            (@Valid @RequestBody AdminDebitWalletReportRequest adminDebitWalletReportRequest) {

        return new ResponseEntity<>(adminDebitWalletReportService.fetchAdminDebitWalletReport
                (adminDebitWalletReportRequest), HttpStatus.OK);
    }
}
