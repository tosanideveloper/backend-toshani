package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.Aeps1AadharPayCommissionGetAll;
import com.toshaniFintech.user_service.dto.request.Aeps1AadharPayCommissionRequestDTO;
import com.toshaniFintech.user_service.dto.response.Aeps1AadharPayCommissionResponseDTO;
import com.toshaniFintech.user_service.model.Aeps1AadharPayCommissionModel;
import com.toshaniFintech.user_service.service.Aeps1AadharPayCommissionService;
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
@RequestMapping("api/v1/aeps1-aadhaar-pay-commission")

@Tag(name = "Aeps1 Aadhaar Pay Commission API", description = "APIs for Aeps1 Aadhaar Pay Commission CRUD")

public class Aeps1AadharPayCommissionController {

    @Autowired
    private Aeps1AadharPayCommissionService aeps1AadharPayCommissionService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/create")
    @Operation(summary = "Create Aeps1 Aadhaar Pay", description = "Create Aeps1 Aadhaar Pay Commission")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Aeps1 Aadhaar Pay Commission created successfully",
            content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})

    public ResponseEntity<APIResponse<Aeps1AadharPayCommissionResponseDTO>> create(
            @Valid @RequestBody Aeps1AadharPayCommissionRequestDTO aeps1AadharPayCommissionRequestDTO) {

        Aeps1AadharPayCommissionModel aeps1AadharPayCommissionModel = objectMapper.convertValue(
                aeps1AadharPayCommissionRequestDTO, Aeps1AadharPayCommissionModel.class);

        Aeps1AadharPayCommissionModel saved = aeps1AadharPayCommissionService.create(aeps1AadharPayCommissionModel);

        Aeps1AadharPayCommissionResponseDTO response = objectMapper.convertValue(
                saved, Aeps1AadharPayCommissionResponseDTO.class);

        return ResponseUtil.success("Aeps1 Aadhaar Pay created successfully", response, HttpStatus.OK);
    }

    @PostMapping("/all")
    @Operation(summary = "Get Aeps1 Aadhaar Pay",
            description = "Get Aeps1 Aadhaar Pay commission with pagination and search")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aeps1 Aadhaar Pay fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<PaginatedResponse<Aeps1AadharPayCommissionResponseDTO>> getAll(
            @Valid @RequestBody Aeps1AadharPayCommissionGetAll aeps1AadharPayCommissionGetAll) {

        return new ResponseEntity<>(aeps1AadharPayCommissionService.getAll(aeps1AadharPayCommissionGetAll),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Aeps1 Aadhaar Pay by ID", description = "Fetch single Aeps1 Aadhaar Pay by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aeps1 Aadhaar Pay fetched successfully"),
            @ApiResponse(responseCode = "404", description = "Aeps1 Aadhaar Pay not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<APIResponse<Aeps1AadharPayCommissionResponseDTO>> getById(
            @PathVariable String id) {

        Aeps1AadharPayCommissionResponseDTO aeps1AadharPayCommissionResponseDTO =
                aeps1AadharPayCommissionService.getById(id);

        return ResponseUtil.success("Aeps1 Aadhaar Pay fetched successfully",
                aeps1AadharPayCommissionResponseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update Aeps1 Aadhaar Pay", description = "Update Aeps1 Aadhaar Pay commission")
    @ApiResponses(value = {@ApiResponse(responseCode = "200",
            description = "Aeps1 Aadhaar Pay updated successfully", content = @Content(
            schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Aeps1 Aadhaar Pay not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})

    public ResponseEntity<APIResponse<Aeps1AadharPayCommissionResponseDTO>> update(
            @PathVariable String id,
            @Valid @RequestBody Aeps1AadharPayCommissionRequestDTO aeps1AadharPayCommissionRequestDTO) {

        Aeps1AadharPayCommissionModel aeps1AadharPayCommissionModel = objectMapper.convertValue(
                aeps1AadharPayCommissionRequestDTO, Aeps1AadharPayCommissionModel.class);

        Aeps1AadharPayCommissionResponseDTO aeps1AadharPayCommissionResponseDTO =
                aeps1AadharPayCommissionService.update(id, aeps1AadharPayCommissionModel);

        return ResponseUtil.success("Aeps1 Aadhaar Pay updated successfully",
                aeps1AadharPayCommissionResponseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete Aeps1 Aadhaar Pay", description = "Delete Aeps1 Aadhaar Pay commission by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aeps1 Aadhaar Pay deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Aeps1 Aadhaar Pay not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<APIResponse<String>> delete(
            @PathVariable String id) {

        aeps1AadharPayCommissionService.delete(id);

        return ResponseUtil.success("Aeps1 Aadhaar Pay deleted successfully", "Deleted",
                HttpStatus.OK);
    }
}
