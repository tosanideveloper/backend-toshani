package com.toshaniFintech.user_service.controller;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.Dmt2ReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.Dmt2ReportResponseDTO;
import com.toshaniFintech.user_service.service.Dmt2ReportService;
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
@RequestMapping("api/v1/dmt2-report")
@Tag(name = "DMT2 Report API", description = "APIs for DMT2 Report")
public class Dmt2ReportController {

    @Autowired
    private Dmt2ReportService service;

    @PostMapping("/all")
    @Operation(summary = "DMT2 Report", description = "Get DMT2 report with pagination and advanced filter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Report fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<PaginatedResponse<Dmt2ReportResponseDTO>> fetchDmt2Report(
            @Valid @RequestBody Dmt2ReportRequestDTO requestDTO) {

        return new ResponseEntity<>(service.fetchDmt2Report(requestDTO), HttpStatus.OK);
    }
}