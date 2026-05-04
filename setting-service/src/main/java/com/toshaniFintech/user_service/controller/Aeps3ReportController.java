package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.Aeps3ReportRequest;
import com.toshaniFintech.user_service.dto.response.Aeps3ReportResponse;
import com.toshaniFintech.user_service.service.Aeps3ReportService;
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
@RequestMapping("api/v1/aeps3-report")
@Tag(name = "Aeps3 Report API", description = "APIs for Manage AEPS3 Report CRUD")
public class Aeps3ReportController {
    @Autowired
    private Aeps3ReportService aeps3ReportService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/all")
    @Operation(summary = "Aeps3 Report", description = "Get Aeps3 Report with pagination and advanced filter")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Aeps3 Report fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"), @ApiResponse(responseCode = "500",
            description = "Internal server error")})
    public ResponseEntity<PaginatedResponse<Aeps3ReportResponse>> fetchAeps3Report
            (@Valid @RequestBody Aeps3ReportRequest aeps3ReportRequest) {

        return new ResponseEntity<>(aeps3ReportService.fetchAeps3Report(aeps3ReportRequest), HttpStatus.OK);
    }
}
