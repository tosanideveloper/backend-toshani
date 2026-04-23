package com.toshaniFintech.user_service.controller;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.UpiCollectReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.UpiCollectReportResponseDTO;
import com.toshaniFintech.user_service.service.UpiCollectReportService;
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
@RequestMapping("api/v1/upicollect-report")
@Tag(name = "UPI Collect Report API", description = "APIs for UPI Collect Report")
public class UpiCollectReportController {

    @Autowired
    private UpiCollectReportService service;

    @PostMapping("/all")
    @Operation(summary = "UPI Collect Report", description = "Get UPI Collect report with pagination and advanced filter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Report fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<PaginatedResponse<UpiCollectReportResponseDTO>> fetchUpiCollectReport(
            @Valid @RequestBody UpiCollectReportRequestDTO requestDTO) {

        return new ResponseEntity<>(service.fetchUpiCollectReport(requestDTO), HttpStatus.OK);
    }
}