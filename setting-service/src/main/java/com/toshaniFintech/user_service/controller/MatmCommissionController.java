package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.MatmCommissionGetAll;
import com.toshaniFintech.user_service.dto.request.MatmCommissionRequestDTO;
import com.toshaniFintech.user_service.dto.response.MatmCommissionResponseDTO;
import com.toshaniFintech.user_service.model.MatmCommissionModel;
import com.toshaniFintech.user_service.service.MatmCommissionService;
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
@RequestMapping("api/v1/matm-commission")

@Tag(name = "Matm Commission API", description = "APIs for Matm Commission")
public class MatmCommissionController {

    @Autowired
    private MatmCommissionService matmCommissionService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/create")
    @Operation(summary = "Create Matm Commission", description = "Create Matm Commission")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Matm Commission created successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<MatmCommissionResponseDTO>> create(
            @Valid @RequestBody MatmCommissionRequestDTO matmCommissionRequestDTO) {

        MatmCommissionModel matmCommissionModel =
                objectMapper.convertValue(matmCommissionRequestDTO, MatmCommissionModel.class);

        MatmCommissionModel saved = matmCommissionService.create(matmCommissionModel);

        MatmCommissionResponseDTO response =
                objectMapper.convertValue(saved, MatmCommissionResponseDTO.class);

        return ResponseUtil.success("Matm Commission created successfully", response, HttpStatus.OK);
    }

    @PostMapping("/all")
    @Operation(summary = "Get Matm Commission",
            description = "Get Matm commission with pagination and search")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Matm Commission fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<PaginatedResponse<MatmCommissionResponseDTO>> getAll(
            @Valid @RequestBody MatmCommissionGetAll matmCommissionGetAll) {

        return new ResponseEntity<>(matmCommissionService.getAll(matmCommissionGetAll), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Matm Commission by ID", description = "Fetch single Matm Commission by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Matm Commission fetched successfully"),
            @ApiResponse(responseCode = "404", description = "Matm Commission not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<MatmCommissionResponseDTO>> getById(
            @PathVariable String id) {

        MatmCommissionResponseDTO matmCommissionResponseDTO = matmCommissionService.getById(id);

        return ResponseUtil.success("Matm Commission fetched successfully", matmCommissionResponseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update Matm Commission", description = "Update Matm commission")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Matm Commission updated successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Matm Commission not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<MatmCommissionResponseDTO>> update(
            @PathVariable String id,
            @Valid @RequestBody MatmCommissionRequestDTO matmCommissionRequestDTO) {

        MatmCommissionModel matmCommissionModel =
                objectMapper.convertValue(matmCommissionRequestDTO, MatmCommissionModel.class);

        MatmCommissionResponseDTO matmCommissionResponseDTO = matmCommissionService.update(id, matmCommissionModel);

        return ResponseUtil.success("Matm Commission updated successfully", matmCommissionResponseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete Matm Commission", description = "Delete Matm commission by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Matm Commission deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Matm Commission not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<String>> delete(@PathVariable String id) {

        matmCommissionService.delete(id);

        return ResponseUtil.success("Matm Commission deleted successfully", "Deleted", HttpStatus.OK);
    }
}
