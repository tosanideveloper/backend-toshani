package com.toshaniFintech.user_service.controller;

import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.RechargeReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.RechargeReportResponseDTO;
import com.toshaniFintech.user_service.service.RechargeReportService;
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
@RequestMapping("api/v1/recharge-report")
@Tag(name = "Recharge Report API", description = "APIs for Recharge Report")
public class RechargeReportController {

    @Autowired
    private RechargeReportService rechargeReportService;

    @PostMapping("/get")
    @Operation(summary = "Get Recharge Report", description = "Get recharge report data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recharge Report fetched successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<List<RechargeReportResponseDTO>>> getRechargeReport(
            @Valid @RequestBody RechargeReportRequestDTO requestDTO) {

        List<RechargeReportResponseDTO> response = rechargeReportService.getRechargeReport(requestDTO);

        return ResponseUtil.success("Recharge Report fetched successfully", response, HttpStatus.OK);
    }

}