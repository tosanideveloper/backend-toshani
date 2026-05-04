package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.Aeps3CommissionGetAll;
import com.toshaniFintech.user_service.dto.request.Aeps3CommissionRequestDTO;
import com.toshaniFintech.user_service.dto.response.Aeps3CommissionResponseDTO;
import com.toshaniFintech.user_service.model.Aeps3CommissionModel;
import com.toshaniFintech.user_service.service.Aeps3CommissionService;
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
@RequestMapping("api/v1/aeps3-commission")

@Tag(name = "Aeps3 Commission API", description = "APIs for Aeps3 Commission CRUD")

public class Aeps3CommissionController {
    @Autowired
    private Aeps3CommissionService aeps3CommissionService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/create")
    @Operation(summary = "Create Aeps3 commission", description = "Create Aeps3 Commission")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Aeps3 commission created successfully",
            content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})

    public ResponseEntity<APIResponse<Aeps3CommissionResponseDTO>> createAeps3(
            @Valid @RequestBody Aeps3CommissionRequestDTO aeps3CommissionRequestDTO) {

        Aeps3CommissionModel aeps3CommissionModel = objectMapper.convertValue(
                aeps3CommissionRequestDTO, Aeps3CommissionModel.class);

        Aeps3CommissionModel saved = aeps3CommissionService.createAeps3(aeps3CommissionModel);

        Aeps3CommissionResponseDTO response = objectMapper.convertValue(saved, Aeps3CommissionResponseDTO.class);

        return ResponseUtil.success("Aeps3 commission created successfully", response, HttpStatus.OK);
    }

    @PostMapping("/all")
    @Operation(summary = "Get Aeps3", description = "Get Aeps3 commission with pagination and search")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Aeps3 commission fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<PaginatedResponse<Aeps3CommissionResponseDTO>> getAllAeps3(
            @Valid @RequestBody Aeps3CommissionGetAll aeps3CommissionGetAll) {

        return new ResponseEntity<>(aeps3CommissionService.getAllAeps3(aeps3CommissionGetAll), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Aeps3 commission by ID", description = "Fetch single Aeps3 commission by ID")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Aeps3 commission fetched successfully"),
            @ApiResponse(responseCode = "404", description = "Aeps3 commission not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<APIResponse<Aeps3CommissionResponseDTO>> getByIdAeps3(
            @PathVariable String id) {

        Aeps3CommissionResponseDTO aeps3CommissionResponseDTO = aeps3CommissionService.getByIdAeps3(id);

        return ResponseUtil.success("Aeps3 commission fetched successfully",
                aeps3CommissionResponseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update Aeps3 commission", description = "Update Aeps3 commission")
    @ApiResponses(value = {@ApiResponse(responseCode = "200",
            description = "Aeps3 commission updated successfully", content = @Content(
            schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Aeps3 commission not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})

    public ResponseEntity<APIResponse<Aeps3CommissionResponseDTO>> updateAeps3(
            @PathVariable String id,
            @Valid @RequestBody Aeps3CommissionRequestDTO aeps3CommissionRequestDTO) {

        Aeps3CommissionModel aeps3CommissionModel = objectMapper.convertValue(
                aeps3CommissionRequestDTO, Aeps3CommissionModel.class);

        Aeps3CommissionResponseDTO aeps3CommissionResponseDTO = aeps3CommissionService.
                updateAeps3(id, aeps3CommissionModel);

        return ResponseUtil.success("Aeps3 commission updated successfully",
                aeps3CommissionResponseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete Aeps3 commission", description = "Delete Aeps3 commission by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aeps3 commission deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Aeps3 commission not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<APIResponse<String>> deleteAeps3(
            @PathVariable String id) {

        aeps3CommissionService.deleteAeps3(id);

        return ResponseUtil.success("Aeps3 commission deleted successfully", "Deleted", HttpStatus.OK);
    }
}
