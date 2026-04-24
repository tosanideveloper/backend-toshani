package com.toshaniFintech.user_service.controller;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.Dmt3ReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.Dmt3ReportResponseDTO;
import com.toshaniFintech.user_service.service.Dmt3ReportService;
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
@RequestMapping("api/v1/dmt3-report")
@Tag(name = "DMT3 Report API", description = "APIs for DMT3 Report")
public class Dmt3ReportController {

    @Autowired
    private Dmt3ReportService service;

    @PostMapping("/get")
    @Operation(summary = "DMT3 Report", description = "Get DMT3 report with pagination and advanced filter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Report fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<PaginatedResponse<Dmt3ReportResponseDTO>> fetchDmt3Report(
            @Valid @RequestBody Dmt3ReportRequestDTO requestDTO) {

        return new ResponseEntity<>(service.fetchDmt3Report(requestDTO), HttpStatus.OK);
    }
}