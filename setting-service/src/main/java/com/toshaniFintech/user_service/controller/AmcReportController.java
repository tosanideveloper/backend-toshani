package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.AmcReportRequest;
import com.toshaniFintech.user_service.dto.response.AmcReportResponse;
import com.toshaniFintech.user_service.service.AmcReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/amc-report")
@Tag(name = "Amc Report Service API", description = "APIs for Manage AMC Report Service CRUD")
public class AmcReportController {
    @Autowired
    private AmcReportService amcReportService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/all")
    @Operation(summary = "Amc Report", description = "Get Amc Report with pagination and advanced filter")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Amc Report fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"), @ApiResponse(responseCode = "500",
            description = "Internal server error")})
    public ResponseEntity<PaginatedResponse<AmcReportResponse>> fetchAmcReport
            (@Valid @RequestBody AmcReportRequest amcReportRequest) {
        return new ResponseEntity<>(amcReportService.fetchAmcReport(amcReportRequest), HttpStatus.OK);
    }
}
