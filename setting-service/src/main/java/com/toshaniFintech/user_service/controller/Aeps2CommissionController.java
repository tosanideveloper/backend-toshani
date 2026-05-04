package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.Aeps2CommissionGetAll;
import com.toshaniFintech.user_service.dto.request.Aeps2CommissionRequestDTO;
import com.toshaniFintech.user_service.dto.response.Aeps2CommissionResponseDTO;
import com.toshaniFintech.user_service.model.Aeps2CommissionModel;
import com.toshaniFintech.user_service.service.Aeps2CommissionService;
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
@RequestMapping("api/v1/aeps2-commission")

@Tag(name = "Aeps2 Commission API", description = "APIs for Aeps2 Commission CRUD")

public class Aeps2CommissionController {
    @Autowired
    private Aeps2CommissionService aeps2CommissionService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/create")
    @Operation(summary = "Create Aeps2", description = "Create Aeps2 Commission")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Aeps2 Commission fetched successfully",
            content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})

    public ResponseEntity<APIResponse<Aeps2CommissionResponseDTO>> create(
            @Valid @RequestBody Aeps2CommissionRequestDTO aeps2CommissionRequestDTO) {

        Aeps2CommissionModel aeps2CommissionModel = objectMapper.convertValue(
                aeps2CommissionRequestDTO, Aeps2CommissionModel.class);

        Aeps2CommissionModel saved = aeps2CommissionService.create(aeps2CommissionModel);

        Aeps2CommissionResponseDTO response = objectMapper.convertValue(saved, Aeps2CommissionResponseDTO.class);

        return ResponseUtil.success("Aeps2 Commission fetched successfully", response, HttpStatus.OK);
    }

    @PostMapping("/all")
    @Operation(summary = "Get Aeps2", description = "Get Aeps2 commission with pagination and search")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Aeps2 commission fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<PaginatedResponse<Aeps2CommissionResponseDTO>> getAll(
            @Valid @RequestBody Aeps2CommissionGetAll aeps2CommissionGetAll) {

        return new ResponseEntity<>(aeps2CommissionService.getAll(aeps2CommissionGetAll), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Aeps2 commission by ID", description = "Fetch single Aeps2 commission by ID")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Aeps2 commission fetched successfully"),
            @ApiResponse(responseCode = "404", description = "Aeps2 commission not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<APIResponse<Aeps2CommissionResponseDTO>> getById(
            @PathVariable String id) {

        Aeps2CommissionResponseDTO aeps2CommissionResponseDTO = aeps2CommissionService.getById(id);

        return ResponseUtil.success("Aeps2 commission fetched successfully",
                aeps2CommissionResponseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update Aeps2", description = "Update Aeps2 commission")
    @ApiResponses(value = {@ApiResponse(responseCode = "200",
            description = "Aeps2 commission updated successfully", content = @Content(
            schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Aeps2 commission not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})

    public ResponseEntity<APIResponse<Aeps2CommissionResponseDTO>> update(
            @PathVariable String id,
            @Valid @RequestBody Aeps2CommissionRequestDTO aeps2CommissionRequestDTO) {

        Aeps2CommissionModel aeps2CommissionModel = objectMapper.convertValue(
                aeps2CommissionRequestDTO, Aeps2CommissionModel.class);

        Aeps2CommissionResponseDTO aeps2CommissionResponseDTO = aeps2CommissionService.
                update(id, aeps2CommissionModel);

        return ResponseUtil.success("Aeps2 commission updated successfully",
                aeps2CommissionResponseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete Aeps2", description = "Delete Aeps2 commission by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aeps2 commission deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Aeps2 commission not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<APIResponse<String>> delete(
            @PathVariable String id) {

        aeps2CommissionService.delete(id);

        return ResponseUtil.success("Aeps2 commission deleted successfully", "Deleted", HttpStatus.OK);
    }
}
