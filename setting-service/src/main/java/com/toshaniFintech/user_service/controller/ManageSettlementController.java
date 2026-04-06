package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.user_service.dto.request.SiteSettingRequestDTO;
import com.toshaniFintech.user_service.dto.response.APIResponse;
import com.toshaniFintech.user_service.dto.response.ManageSettlementResponseDTO;
import com.toshaniFintech.user_service.model.ManageSettlementModel;
import com.toshaniFintech.user_service.service.ManageSettlementService;
import com.toshaniFintech.user_service.util.ResponseUtil;
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
@RequestMapping("/api/v1/settlement")
@Tag(name = "Manage Settlement Time API", description = "APIs for Manage Settlement time CRUD")
public class ManageSettlementController {

    @Autowired
    ManageSettlementService manageSettlementService;

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("/get-all")
    @Operation(
            summary = "Manage Settlement",
            description = "This api is to get settlement time"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Manage settlement time fetched successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<List<ManageSettlementModel>>> getAllSettlementTime() {
        return ResponseUtil.success("Manage settlement time fetched successfully", manageSettlementService.getAllSettlementTime(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    @Operation(
            summary = "Manage Settlement",
            description = "This api is to get settlement time by ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Manage settlement time fetched successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "Data does not exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<ManageSettlementModel>> getSettlementTimeById(@PathVariable String id) {
        return ResponseUtil.success("Manage settlement time fetched successfully", manageSettlementService.getSettlementTimeById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @Operation(
            summary = "Manage Settlement",
            description = "This api is to update settlement time"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Manage settlement time updated successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "Data does not exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<ManageSettlementResponseDTO>> updateSettlementTime(@PathVariable String id, @Valid @RequestBody SiteSettingRequestDTO siteSettingRequestDTO) {
        ManageSettlementModel manageSettlementModel = objectMapper.convertValue(siteSettingRequestDTO, ManageSettlementModel.class);
        ManageSettlementModel updatedModel = manageSettlementService.updateSettlementTime(id, manageSettlementModel);
        ManageSettlementResponseDTO responseDTO = objectMapper.convertValue(updatedModel, ManageSettlementResponseDTO.class);
        return ResponseUtil.success("Manage settlement time updated successfully", responseDTO, HttpStatus.OK);
    }

}
