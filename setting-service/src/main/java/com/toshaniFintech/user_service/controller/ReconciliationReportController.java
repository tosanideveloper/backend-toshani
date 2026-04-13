package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.ReconciliationReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.ReconciliationReportResponseDTO;
import com.toshaniFintech.user_service.model.ReconciliationReportModel;
import com.toshaniFintech.user_service.service.ReconciliationReportService;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/reconciliation-report")
@Tag(name = "Reconciliation Report API", description = "APIs for Reconciliation Report CRUD")
public class ReconciliationReportController {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ReconciliationReportService reconciliationReportService;

    @PostMapping("/create")
    @Operation(summary = "ReconciliationReport", description = "Create a API for Reconciliation Report")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Reconciliation Report created successfully", content = @Content(schema = @Schema(implementation = APIResponse.class))), @ApiResponse(responseCode = "400", description = "Invalid input data"), @ApiResponse(responseCode = "409", description = "User already exists"), @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<APIResponse<ReconciliationReportResponseDTO>> createReconciliationReport(@Valid @RequestBody ReconciliationReportRequestDTO reconciliationReportrequestDTO) {
        ReconciliationReportModel reconciliationReportModel = objectMapper.convertValue(reconciliationReportrequestDTO, ReconciliationReportModel.class);
        ReconciliationReportModel updatedModel = reconciliationReportService.createReconciliationReport(reconciliationReportModel);
        ReconciliationReportResponseDTO responseDTO = objectMapper.convertValue(updatedModel, ReconciliationReportResponseDTO.class);
        return ResponseUtil.success("Reconciliation Report created successfully", responseDTO, HttpStatus.OK);
    }
}
