package com.toshaniFintech.user_service.controller;

import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.MatmReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.MatmReportResponseDTO;
import com.toshaniFintech.user_service.service.MatmReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/matm-report")
@Tag(name = "Matm Report API", description = "APIs for Matm Report")
public class MatmReportController {

    @Autowired
    private MatmReportService matmReportService;

    @PostMapping("/get")
    @Operation(summary = "Get Matm Report", description = "Get MATM report data")
    public ResponseEntity<APIResponse<List<MatmReportResponseDTO>>> getMatmReport(
            @Valid @RequestBody MatmReportRequestDTO requestDTO) {

        List<MatmReportResponseDTO> response =
                matmReportService.getMatmReport(requestDTO);

        return ResponseUtil.success("Matm Report fetched successfully", response, HttpStatus.OK);
    }
}
