package com.toshaniFintech.user_service.controller;

import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.VerificationReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.VerificationReportResponseDTO;
import com.toshaniFintech.user_service.service.VerificationReportService;
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
@RequestMapping("api/v1/verification-report")
@Tag(name = "Verification Report API", description = "APIs for Verification Report")
public class VerificationReportController {

    @Autowired
    private VerificationReportService verificationReportService;

    @PostMapping("/get")
    @Operation(summary = "Get Verification Report", description = "Get verification report data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Verification Report fetched successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<List<VerificationReportResponseDTO>>> getVerificationReport(
            @Valid @RequestBody VerificationReportRequestDTO requestDTO) {

        List<VerificationReportResponseDTO> response =
                verificationReportService.getVerificationReport(requestDTO);

        return ResponseUtil.success("Verification Report fetched successfully", response, HttpStatus.OK);
    }
}