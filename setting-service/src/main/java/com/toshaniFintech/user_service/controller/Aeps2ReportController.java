package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.Aeps2ReportRequestDTO;
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
@Tag(name = "Aeps2 Report API", description = "APIs for Aeps2 Report")
public class Aeps2ReportController {

    @Autowired
    private Aeps2ReportService aeps2ReportService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/get")
    @Operation(summary = "Get Aeps2 Report", description = "Get Aeps2 report data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aeps2 Report fetched successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<Aeps2ReportResponseDTO>> getAeps2Report(
            @Valid @RequestBody Aeps2ReportRequestDTO aeps2ReportRequestDTO) {

        Aeps2ReportModel aeps2ReportModel = objectMapper.convertValue(aeps2ReportRequestDTO, Aeps2ReportModel.class);
        Aeps2ReportModel updatedModel = aeps2ReportService.getAeps2Report(aeps2ReportModel);
        Aeps2ReportResponseDTO responseDTO = objectMapper.convertValue(updatedModel, Aeps2ReportResponseDTO.class);

        return ResponseUtil.success("Aeps2 Report fetched successfully", responseDTO, HttpStatus.OK);
    }
}