package com.toshaniFintech.user_service.controller;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.MatmReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.MatmReportResponseDTO;
import com.toshaniFintech.user_service.service.MatmReportService;
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
@RequestMapping("api/v1/matm-report")
@Tag(name = "Matm Report API", description = "APIs for Matm Report")
public class MatmReportController {

    @Autowired
    private MatmReportService matmReportService;
    @PostMapping("/all")
    @Operation(summary = "Get Matm Report", description = "Get MATM report data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Matm Report fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<PaginatedResponse<MatmReportResponseDTO>> fetchMatmReport(
            @Valid @RequestBody MatmReportRequestDTO requestDTO) {

        return new ResponseEntity<>(
                matmReportService.fetchMatmReport(requestDTO),
                HttpStatus.OK
        );
    }

}
