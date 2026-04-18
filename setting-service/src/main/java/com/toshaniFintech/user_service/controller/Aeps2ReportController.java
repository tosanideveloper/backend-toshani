package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.Aeps1ReportRequestDTO;
import com.toshaniFintech.user_service.dto.request.Aeps2ReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.Aeps1ReportResponseDTO;
import com.toshaniFintech.user_service.dto.response.Aeps2ReportResponseDTO;
import com.toshaniFintech.user_service.model.Aeps2ReportModel;
import com.toshaniFintech.user_service.service.Aeps2ReportService;
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

@RestController
@RequestMapping("api/v1/aeps2-report")
@Tag(name = "Aeps2 Report API", description = "APIs for AePS 2 Report")
public class Aeps2ReportController {

    @Autowired
    private Aeps2ReportService aeps2ReportService;


    @PostMapping("/all")
    @Operation(summary = "AePS 2 Report", description = "Get AePS 2 Report with pagination and advanced filter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "AePS 2 Report fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<PaginatedResponse<Aeps2ReportResponseDTO>> fetchAePSTwoReport(
            @Valid @RequestBody Aeps2ReportRequestDTO aeps2ReportRequestDTO) {

        return new ResponseEntity<>(
                aeps2ReportService.fetchAePSTwoReport(aeps2ReportRequestDTO),
                HttpStatus.OK
        );
    }
}