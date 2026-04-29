package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.Aeps2AadharPayCommissionRequestDTO;
import com.toshaniFintech.user_service.dto.response.Aeps2AadharPayCommissionResponseDTO;
import com.toshaniFintech.user_service.model.Aeps2AadharPayCommissionModel;
import com.toshaniFintech.user_service.service.Aeps2AadharPayCommissionService;
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
@RequestMapping("api/v1/aeps2-aadhaar-pay-commission")

@Tag(name = "Aeps2 Aadhaar Pay Commission API", description = "APIs for Aeps2 Aadhaar Pay Commission CRUD")
public class Aeps2AadharPayCommissionController {
    @Autowired
    private Aeps2AadharPayCommissionService aeps2AadharPayCommissionService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/create")
    @Operation(summary = "Create Aeps2 Aadhaar Pay", description = "Create Aeps2 Aadhaar Pay Commission")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Aeps2 Aadhaar Pay created successfully",
            content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})

    public ResponseEntity<APIResponse<Aeps2AadharPayCommissionResponseDTO>> createAeps2AadharPay(
            @Valid @RequestBody Aeps2AadharPayCommissionRequestDTO aeps2AadharPayCommissionRequestDTO) {

        Aeps2AadharPayCommissionModel aeps2AadharPayCommissionModel = objectMapper.convertValue(
                aeps2AadharPayCommissionRequestDTO, Aeps2AadharPayCommissionModel.class);

        Aeps2AadharPayCommissionModel saved = aeps2AadharPayCommissionService.
                createAeps2AadharPay(aeps2AadharPayCommissionModel);

        Aeps2AadharPayCommissionResponseDTO response = objectMapper.convertValue(
                saved, Aeps2AadharPayCommissionResponseDTO.class);

        return ResponseUtil.success("Aeps2 Aadhaar Pay created successfully", response, HttpStatus.OK);
    }

    @PostMapping("/all")
    @Operation(summary = "Get Aeps2 Aadhaar Pay",
            description = "Get Aeps2 Aadhaar Pay commission with pagination and search")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aeps2 Aadhaar Pay fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<PaginatedResponse<Aeps2AadharPayCommissionResponseDTO>> getAllAeps2AadharPay(
            @Valid @RequestBody Aeps2AadharPayCommissionRequestDTO aeps2AadharPayCommissionRequestDTO) {

        return new ResponseEntity<>(aeps2AadharPayCommissionService.
                getAllAeps2AadharPay(aeps2AadharPayCommissionRequestDTO),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Aeps2 Aadhaar Pay by ID", description = "Fetch single Aeps2 Aadhaar Pay by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aeps2 Aadhaar Pay fetched successfully"),
            @ApiResponse(responseCode = "404", description = "Aeps2 Aadhaar Pay not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<APIResponse<Aeps2AadharPayCommissionResponseDTO>> getByIdAeps2AadharPay(
            @PathVariable String id) {

        Aeps2AadharPayCommissionResponseDTO aeps2AadharPayCommissionResponseDTO =
                aeps2AadharPayCommissionService.getByIdAeps2AadharPay(id);

        return ResponseUtil.success("Aeps2 Aadhaar Pay fetched successfully",
                aeps2AadharPayCommissionResponseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update Aeps2 Aadhaar Pay", description = "Update Aeps2 Aadhaar Pay commission")
    @ApiResponses(value = {@ApiResponse(responseCode = "200",
            description = "Aeps2 Aadhaar Pay updated successfully", content = @Content(
            schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Aeps2 Aadhaar Pay not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})

    public ResponseEntity<APIResponse<Aeps2AadharPayCommissionResponseDTO>> updateAeps2AadharPay(
            @PathVariable String id,
            @Valid @RequestBody Aeps2AadharPayCommissionRequestDTO aeps2AadharPayCommissionRequestDTO) {

        Aeps2AadharPayCommissionModel aeps2AadharPayCommissionModel = objectMapper.convertValue(
                aeps2AadharPayCommissionRequestDTO, Aeps2AadharPayCommissionModel.class);

        Aeps2AadharPayCommissionResponseDTO aeps2AadharPayCommissionResponseDTO =
                aeps2AadharPayCommissionService.updateAeps2AadharPay(id, aeps2AadharPayCommissionModel);

        return ResponseUtil.success("Aeps2 Aadhaar Pay updated successfully",
                aeps2AadharPayCommissionResponseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete Aeps2 Aadhaar Pay", description = "Delete Aeps2 Aadhaar Pay commission by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aeps2 Aadhaar Pay deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Aeps2 Aadhaar Pay not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<APIResponse<String>> deleteAeps2AadharPay(
            @PathVariable String id) {

        aeps2AadharPayCommissionService.deleteAeps2AadharPay(id);

        return ResponseUtil.success("Aeps2 Aadhaar Pay deleted successfully", "Deleted",
                HttpStatus.OK);
    }
}
