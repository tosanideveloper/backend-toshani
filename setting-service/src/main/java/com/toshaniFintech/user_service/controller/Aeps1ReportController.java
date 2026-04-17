package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.Aeps1ReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.Aeps1ReportResponseDTO;
import com.toshaniFintech.user_service.model.Aeps1ReportModel;
import com.toshaniFintech.user_service.service.Aeps1ReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/aeps1-report")
@Tag(name = "Aeps1 Report API", description = "APIs for Aeps1 Report CRUD")
public class Aeps1ReportController {

    @Autowired
    private Aeps1ReportService aeps1ReportService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/get")
    @Operation(summary = "Aeps1 Report", description = "Get Aeps1 Report with pagination and advanced filter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aeps1 Report fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<PaginatedResponse<Aeps1ReportResponseDTO>> fetchAepsReport(
            @Valid @RequestBody Aeps1ReportRequestDTO aeps1ReportRequestDTO) {

        return new ResponseEntity<>(
                aeps1ReportService.fetchAepsReport(aeps1ReportRequestDTO),
                HttpStatus.OK
        );
    }
}