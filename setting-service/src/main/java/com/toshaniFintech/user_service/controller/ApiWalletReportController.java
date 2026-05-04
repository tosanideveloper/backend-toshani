package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.ApiWalletReportRequest;
import com.toshaniFintech.user_service.dto.response.ApiWalletReportResponse;
import com.toshaniFintech.user_service.service.ApiWalletReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/api-wallet-report")
public class ApiWalletReportController {
    @Autowired
    private ApiWalletReportService apiWalletReportService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/all")
    @Operation(summary = "Api Wallet Report",
            description = "Get Api Wallet Report with pagination and advanced filter")
    @ApiResponses(value = {@ApiResponse(responseCode = "200",
            description = "Api Wallet Report fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<PaginatedResponse<ApiWalletReportResponse>> fetchApiWalletReport
            (@Valid @RequestBody ApiWalletReportRequest apiWalletReportRequest) {

        return new ResponseEntity<>(apiWalletReportService.fetchApiWalletReport
                (apiWalletReportRequest), HttpStatus.OK);
    }
}
