package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.FinpayApiLogRequest;
import com.toshaniFintech.user_service.dto.response.FinpayApiLogResponse;
import com.toshaniFintech.user_service.service.FinpayApiLogService;
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
@RequestMapping("api/v1/finpay-api-log")
@Tag(name = "Finpay Api Log API", description = "APIs for Manage Finpay Api Log CRUD")
public class FinpayApiLogController {
    @Autowired
    private FinpayApiLogService finpayApiLogService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/all")
    @Operation(summary = "Finpay Api Log",
            description = "Get Finpay Api Log with pagination and advanced filter")
    @ApiResponses(value = {@ApiResponse(responseCode = "200",
            description = "Finpay Api Log fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<PaginatedResponse<FinpayApiLogResponse>> fetchFinpayApiLog
            (@Valid @RequestBody FinpayApiLogRequest finpayApiLogRequest) {

        return new ResponseEntity<>(finpayApiLogService.fetchFinpayApiLog(finpayApiLogRequest), HttpStatus.OK);
    }
}
