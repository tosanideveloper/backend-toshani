package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.CreditWalletReportRequest;
import com.toshaniFintech.user_service.dto.response.CreditWalletReportResponse;
import com.toshaniFintech.user_service.service.CreditWalletReportService;
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
@RequestMapping("api/v1/credit-wallet-report")
@Tag(name = "Credit Wallet Report Service API",
        description = "APIs for Credit Wallet Report Service CRUD")
public class CreditWalletReportController {
    @Autowired
    private CreditWalletReportService creditWalletReportService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/all")
    @Operation(summary = "Credit Wallet Report API",
            description = "Get Credit Wallet Report with pagination and advanced filter")
    @ApiResponses(value = {@ApiResponse(responseCode = "200",
            description = "Credit Wallet Report fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<PaginatedResponse<CreditWalletReportResponse>> fetchCreditWalletReport
            (@Valid @RequestBody CreditWalletReportRequest creditWalletReportRequest) {

        return new ResponseEntity<>(creditWalletReportService.fetchCreditWalletReport
                (creditWalletReportRequest), HttpStatus.OK);
    }
}
