package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.Aeps2MerchantReportRequest;
import com.toshaniFintech.user_service.dto.response.Aeps2MerchantReportResponse;
import com.toshaniFintech.user_service.service.Aeps2MerchantReportService;
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
@RequestMapping("api/v1/aeps2-merchant-report")
@Tag(name = "Aeps2 Merchant Report API", description = "APIs for Manage AEPS2 Merchant Report CRUD")
public class Aeps2MerchantReportController {
    @Autowired
    private Aeps2MerchantReportService aeps2MerchantReportService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/all")
    @Operation(summary = "AEPS2 Merchant Report ", description = "Get AEPS2 Merchant Report with pagination and " +
            "advanced filter")
    @ApiResponses(value = {@ApiResponse(responseCode = "200",
            description = "AEPS2 Merchant Report fetched successfully"), @ApiResponse(responseCode = "400",
            description = "Invalid input data"), @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<PaginatedResponse<Aeps2MerchantReportResponse>> fetchAEPS2MerchantReport
            (@Valid @RequestBody Aeps2MerchantReportRequest aeps2MerchantReportRequest) {

        return new ResponseEntity<>(aeps2MerchantReportService.fetchAeps2MerchantReport
                (aeps2MerchantReportRequest), HttpStatus.OK);
    }
}

