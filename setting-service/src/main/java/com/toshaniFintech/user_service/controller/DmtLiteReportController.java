package com.toshaniFintech.user_service.controller;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.DmtLiteReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.DmtLiteReportResponseDTO;
import com.toshaniFintech.user_service.service.DmtLiteReportService;
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
@RequestMapping("api/v1/dmt-lite-report")
@Tag(name = "DMT Lite Report API", description = "APIs for DMT Lite Report")
public class DmtLiteReportController {

    @Autowired
    private DmtLiteReportService service;

    @PostMapping("/all")
    @Operation(summary = "DMT Lite Report", description = "Get DMT Lite report with pagination and advanced filter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Report fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<PaginatedResponse<DmtLiteReportResponseDTO>> fetchDmtLiteReport(
            @Valid @RequestBody DmtLiteReportRequestDTO requestDTO) {

        return new ResponseEntity<>(service.fetchDmtLiteReport(requestDTO), HttpStatus.OK);
    }
}