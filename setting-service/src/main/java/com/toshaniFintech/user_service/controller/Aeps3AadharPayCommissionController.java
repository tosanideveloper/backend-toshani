package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.Aeps3AadharPayCommissionGetAll;
import com.toshaniFintech.user_service.dto.request.Aeps3AadharPayCommissionRequestDTO;
import com.toshaniFintech.user_service.dto.response.Aeps3AadharPayCommissionResponseDTO;
import com.toshaniFintech.user_service.model.Aeps3AadharPayCommissionModel;
import com.toshaniFintech.user_service.service.Aeps3AadharPayCommissionService;
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
@RequestMapping("api/v1/aeps3-aadhaar-pay-commission")

@Tag(name = "Aeps3 Aadhaar Pay Commission API", description = "APIs for Aeps3 Aadhaar Pay Commission CRUD")

public class Aeps3AadharPayCommissionController {
    @Autowired
    private Aeps3AadharPayCommissionService aeps3AadharPayCommissionService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/create")
    @Operation(summary = "Create Aeps3 Aadhaar Pay", description = "Create Aeps3 Aadhaar Pay Commission")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Aeps3 Aadhaar Pay created successfully",
            content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})

    public ResponseEntity<APIResponse<Aeps3AadharPayCommissionResponseDTO>> createAeps3AadharPay(
            @Valid @RequestBody Aeps3AadharPayCommissionRequestDTO aeps3AadharPayCommissionRequestDTO) {

        Aeps3AadharPayCommissionModel aeps3AadharPayCommissionModel = objectMapper.convertValue(
                aeps3AadharPayCommissionRequestDTO, Aeps3AadharPayCommissionModel.class);

        Aeps3AadharPayCommissionModel saved = aeps3AadharPayCommissionService.
                createAeps3AadharPay(aeps3AadharPayCommissionModel);

        Aeps3AadharPayCommissionResponseDTO response = objectMapper.convertValue(
                saved, Aeps3AadharPayCommissionResponseDTO.class);

        return ResponseUtil.success("Aeps3 Aadhaar Pay created successfully", response, HttpStatus.OK);
    }

    @PostMapping("/all")
    @Operation(summary = "Get Aeps3 Aadhaar Pay",
            description = "Get Aeps3 Aadhaar Pay commission with pagination and search")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aeps3 Aadhaar Pay fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<PaginatedResponse<Aeps3AadharPayCommissionResponseDTO>> getAllAeps3AadharPay(
            @Valid @RequestBody Aeps3AadharPayCommissionGetAll aeps3AadharPayCommissionGetAll) {

        return new ResponseEntity<>(aeps3AadharPayCommissionService.
                getAllAeps3AadharPay(aeps3AadharPayCommissionGetAll),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Aeps3 Aadhaar Pay by ID", description = "Fetch single Aeps3 Aadhaar Pay by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aeps3 Aadhaar Pay fetched successfully"),
            @ApiResponse(responseCode = "404", description = "Aeps3 Aadhaar Pay not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<APIResponse<Aeps3AadharPayCommissionResponseDTO>> getByIdAeps3AadharPay(
            @PathVariable String id) {

        Aeps3AadharPayCommissionResponseDTO aeps3AadharPayCommissionResponseDTO =
                aeps3AadharPayCommissionService.getByIdAeps3AadharPay(id);

        return ResponseUtil.success("Aeps3 Aadhaar Pay fetched successfully",
                aeps3AadharPayCommissionResponseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update Aeps3 Aadhaar Pay", description = "Update Aeps3 Aadhaar Pay commission")
    @ApiResponses(value = {@ApiResponse(responseCode = "200",
            description = "Aeps3 Aadhaar Pay updated successfully", content = @Content(
            schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Aeps3 Aadhaar Pay not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})

    public ResponseEntity<APIResponse<Aeps3AadharPayCommissionResponseDTO>> updateAeps3AadharPay(
            @PathVariable String id,
            @Valid @RequestBody Aeps3AadharPayCommissionRequestDTO aeps3AadharPayCommissionRequestDTO) {

        Aeps3AadharPayCommissionModel aeps3AadharPayCommissionModel = objectMapper.convertValue(
                aeps3AadharPayCommissionRequestDTO, Aeps3AadharPayCommissionModel.class);

        Aeps3AadharPayCommissionResponseDTO aeps3AadharPayCommissionResponseDTO =
                aeps3AadharPayCommissionService.updateAeps3AadharPay(id, aeps3AadharPayCommissionModel);

        return ResponseUtil.success("Aeps3 Aadhaar Pay updated successfully",
                aeps3AadharPayCommissionResponseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete Aeps3 Aadhaar Pay", description = "Delete Aeps3 Aadhaar Pay commission by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aeps3 Aadhaar Pay deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Aeps3 Aadhaar Pay not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<APIResponse<String>> deleteAeps3AadharPay(
            @PathVariable String id) {

        aeps3AadharPayCommissionService.deleteAeps3AadharPay(id);

        return ResponseUtil.success("Aeps3 Aadhaar Pay deleted successfully", "Deleted",
                HttpStatus.OK);
    }
}
