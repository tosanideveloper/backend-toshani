package com.toshaniFintech.user_service.controller;

import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.ModifyReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.ModifyReportResponseDTO;
import com.toshaniFintech.user_service.service.ModifyReportService;
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
@RequestMapping("api/v1/modify-report")
@Tag(name = "Modify Report API", description = "APIs for Modify Report")
public class ModifyReportController {

    @Autowired
    private ModifyReportService modifyReportService;

    @PostMapping("/get")
    @Operation(summary = "Get Modify Report", description = "Get modify report data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Modify Report fetched successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<List<ModifyReportResponseDTO>>> getModifyReport(
            @Valid @RequestBody ModifyReportRequestDTO requestDTO) {

        List<ModifyReportResponseDTO> response = modifyReportService.getModifyReport(requestDTO);

        return ResponseUtil.success("Modify Report fetched successfully", response, HttpStatus.OK);
    }
}