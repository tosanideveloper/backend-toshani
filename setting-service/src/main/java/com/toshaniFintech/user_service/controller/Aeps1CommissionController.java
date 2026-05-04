package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.Aeps1CommissionGetAll;
import com.toshaniFintech.user_service.dto.request.Aeps1CommissionRequestDTO;
import com.toshaniFintech.user_service.dto.response.Aeps1CommissionResponseDTO;
import com.toshaniFintech.user_service.model.Aeps1CommissionModel;
import com.toshaniFintech.user_service.service.Aeps1CommissionService;
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
@RequestMapping("api/v1/aeps1-commission")

@Tag(name = "Aeps1 Commission API", description = "APIs for Aeps1 Commission CRUD")

public class Aeps1CommissionController {

    @Autowired
    private Aeps1CommissionService aeps1CommissionService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/create")
    @Operation(summary = "Create Aeps1", description = "Create Aeps1 Commission")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Aeps1 created successfully",
            content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})

    public ResponseEntity<APIResponse<Aeps1CommissionResponseDTO>> create(
            @Valid @RequestBody Aeps1CommissionRequestDTO aeps1CommissionRequestDTO) {

        Aeps1CommissionModel aeps1CommissionModel = objectMapper.convertValue(
                aeps1CommissionRequestDTO, Aeps1CommissionModel.class);

        Aeps1CommissionModel saved = aeps1CommissionService.create(aeps1CommissionModel);

        Aeps1CommissionResponseDTO response = objectMapper.convertValue(saved, Aeps1CommissionResponseDTO.class);

        return ResponseUtil.success("Aeps1 created successfully", response, HttpStatus.OK);
    }

    @PostMapping("/all")
    @Operation(summary = "Get Aeps1", description = "Get Aeps1 commission with pagination and search")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Aeps1 fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<PaginatedResponse<Aeps1CommissionResponseDTO>> getAll(
            @Valid @RequestBody Aeps1CommissionGetAll aeps1CommissionGetAll) {

        return new ResponseEntity<>(aeps1CommissionService.getAll(aeps1CommissionGetAll), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Aeps1 by ID", description = "Fetch single Aeps1 by ID")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Aeps1 fetched successfully"),
            @ApiResponse(responseCode = "404", description = "Aeps1 not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<APIResponse<Aeps1CommissionResponseDTO>> getById(
            @PathVariable String id) {

        Aeps1CommissionResponseDTO aeps1CommissionResponseDTO = aeps1CommissionService.getById(id);

        return ResponseUtil.success("Aeps1 fetched successfully",
                aeps1CommissionResponseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update Aeps1", description = "Update Aeps1 commission")
    @ApiResponses(value = {@ApiResponse(responseCode = "200",
            description = "Aeps1 updated successfully", content = @Content(
                    schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Aeps1 not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})

    public ResponseEntity<APIResponse<Aeps1CommissionResponseDTO>> update(
            @PathVariable String id,
            @Valid @RequestBody Aeps1CommissionRequestDTO aeps1CommissionRequestDTO) {

        Aeps1CommissionModel aeps1CommissionModel = objectMapper.convertValue(
                aeps1CommissionRequestDTO, Aeps1CommissionModel.class);

        Aeps1CommissionResponseDTO aeps1CommissionResponseDTO = aeps1CommissionService.
                update(id, aeps1CommissionModel);

        return ResponseUtil.success("Aeps1 updated successfully",
                aeps1CommissionResponseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete Aeps1", description = "Delete Aeps1 commission by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aeps1 deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Aeps1 not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<APIResponse<String>> delete(
            @PathVariable String id) {

        aeps1CommissionService.delete(id);

        return ResponseUtil.success("Aeps1 deleted successfully", "Deleted", HttpStatus.OK);
    }
}
