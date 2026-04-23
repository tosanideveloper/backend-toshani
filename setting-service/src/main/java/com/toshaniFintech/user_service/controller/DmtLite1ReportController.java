package com.toshaniFintech.user_service.controller;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.DmtLite1ReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.DmtLite1ReportResponseDTO;
import com.toshaniFintech.user_service.service.DmtLite1ReportService;
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
@RequestMapping("api/v1/dmt-lite1-report")
@Tag(name = "DMT Lite1 Report API", description = "APIs for DMT Lite1 Report")
public class DmtLite1ReportController {

    @Autowired
    private DmtLite1ReportService service;

    @PostMapping("/all")
    @Operation(summary = "DMT Lite1 Report", description = "Get DMT Lite1 report with pagination and advanced filter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Report fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<PaginatedResponse<DmtLite1ReportResponseDTO>> fetchDmtLite1Report(
            @Valid @RequestBody DmtLite1ReportRequestDTO requestDTO) {

        return new ResponseEntity<>(service.fetchDmtLite1Report(requestDTO), HttpStatus.OK);
    }
}