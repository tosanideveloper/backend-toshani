package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.PartnerManagementRequestDTO;
import com.toshaniFintech.user_service.dto.response.PartnerManagementResponseDTO;
import com.toshaniFintech.user_service.model.PartnerManagementModel;
import com.toshaniFintech.user_service.service.PartnerManagementService;
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
@RequestMapping("/api/v1/api-partner")
@Tag(name = "Partner Management API", description = "APIs for add partner management ")
public class PartnerManagementController {
    @Autowired
    private PartnerManagementService partnerManagementService;

    @Autowired
    private ObjectMapper objectMapper;


    @GetMapping("/all")
    @Operation(summary = "Partner Management user", description = "get a partner management")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Partner Management user fetched successfully", content = @Content(schema = @Schema(implementation = APIResponse.class))), @ApiResponse(responseCode = "400", description = "Invalid input data"), @ApiResponse(responseCode = "409", description = "User already exists"), @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<APIResponse<List<PartnerManagementModel>>> getPartnerManagement() {
        return ResponseUtil.success("Partner Management fetched successfully", partnerManagementService.getPartnerManagement(), HttpStatus.OK);
    }

    @PostMapping("/create")
    @Operation(summary = "Partner Management user", description = "This api is to Create Add partner management")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Add partner management created successfully", content = @Content(schema = @Schema(implementation = APIResponse.class))), @ApiResponse(responseCode = "400", description = "Invalid input data"), @ApiResponse(responseCode = "409", description = "Data does not exists"), @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<APIResponse<PartnerManagementResponseDTO>> createPartnerManagement(@Valid @RequestBody PartnerManagementRequestDTO partnerManagementRequestDTO) {
        PartnerManagementModel partnerManagementModel = objectMapper.convertValue(partnerManagementRequestDTO, PartnerManagementModel.class);
        PartnerManagementModel addPartnerManagementModel = partnerManagementService.createPartnerManagement(partnerManagementModel);
        PartnerManagementResponseDTO responseDTO = objectMapper.convertValue(addPartnerManagementModel, PartnerManagementResponseDTO.class);
        return ResponseUtil.success("Partner Management user created successfully", responseDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Partner Management", description = "This api is to get by ID")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Apis service get by ID successfully", content = @Content(schema = @Schema(implementation = APIResponse.class))), @ApiResponse(responseCode = "400", description = "Invalid input data"), @ApiResponse(responseCode = "409", description = "User already exists"), @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<APIResponse<PartnerManagementModel>> getPartnerManagement(@PathVariable String id) {
        return ResponseUtil.success("Partner Management get by ID successfully", partnerManagementService.getPartnerManagementByID(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Partner Management", description = "This api is to update Api Service list")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Apis service updated successfully", content = @Content(schema = @Schema(implementation = APIResponse.class))), @ApiResponse(responseCode = "400", description = "Invalid input data"), @ApiResponse(responseCode = "409", description = "User already exists"), @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<APIResponse<PartnerManagementResponseDTO>> updatePartnerManagement(@PathVariable String id, @Valid @RequestBody PartnerManagementRequestDTO partnerManagementRequestDTO) {
        PartnerManagementModel partnerManagementModel = objectMapper.convertValue(partnerManagementService, PartnerManagementModel.class);
        PartnerManagementModel updatedModel = partnerManagementService.updatePartnerManagement(id, partnerManagementModel);
        PartnerManagementResponseDTO responseDTO = objectMapper.convertValue(updatedModel, PartnerManagementResponseDTO.class);
        return ResponseUtil.success("Partner Management updated successfully", responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Partner Management user", description = "This api is to Delete API for Partner Management")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Partner Management user Services deleted successfully", content = @Content(schema = @Schema(implementation = APIResponse.class))), @ApiResponse(responseCode = "400", description = "Invalid input data"), @ApiResponse(responseCode = "409", description = "Data does not exists"), @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<APIResponse<Object>> deletePartnerManagement(@PathVariable String id) {
        partnerManagementService.deletePartnerManagement(id);
        return ResponseUtil.success("Partner Management user deleted successfully", null, HttpStatus.OK);
    }
}
