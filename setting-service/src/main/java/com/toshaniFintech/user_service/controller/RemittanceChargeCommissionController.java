package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.RemittanceChargeCommissionGetRequest;
import com.toshaniFintech.user_service.dto.request.RemittanceChargeCommissionRequest;
import com.toshaniFintech.user_service.dto.response.RemittanceChargeCommissionResponse;
import com.toshaniFintech.user_service.model.RemittanceChargeCommissionModel;
import com.toshaniFintech.user_service.service.RemittanceChargeCommissionService;
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
@RequestMapping("api/v1/remittance-charge-commission")
@Tag(name = "Remittance Charge Commission Service API",
        description = "APIs for Manage Remittance Charge Commission Service CRUD")
public class RemittanceChargeCommissionController {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RemittanceChargeCommissionService service;

    @PostMapping("/create")
    @Operation(summary = "Create Remittance Charge", description = "Create Remittance Charge Commission")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Charge created successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<RemittanceChargeCommissionResponse>> create(
            @Valid @RequestBody RemittanceChargeCommissionRequest request) {

        RemittanceChargeCommissionModel model =
                objectMapper.convertValue(request, RemittanceChargeCommissionModel.class);

        RemittanceChargeCommissionModel saved = service.create(model);

        RemittanceChargeCommissionResponse response =
                objectMapper.convertValue(saved, RemittanceChargeCommissionResponse.class);

        return ResponseUtil.success("Charge created successfully", response, HttpStatus.OK);
    }

    @PostMapping("/all")
    @Operation(summary = "Get Remittance Charge",
            description = "Get Remittance Charge Commission with pagination and search")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Charges fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<PaginatedResponse<RemittanceChargeCommissionResponse>> fetchRemittanceChargeCommission(
            @Valid @RequestBody RemittanceChargeCommissionGetRequest request) {

        return new ResponseEntity<>(service.fetchRemittanceChargeCommission(request), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    @Operation(summary = "Get Remittance Charge by ID", description = "Fetch single charge by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Charge fetched successfully"),
            @ApiResponse(responseCode = "404", description = "Charge not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<RemittanceChargeCommissionResponse>> getById(
            @PathVariable String id) {

        RemittanceChargeCommissionResponse response = service.getById(id);

        return ResponseUtil.success("Charge fetched successfully", response, HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    @Operation(summary = "Update Remittance Charge Commission", description = "Update Remittance Charge Commission")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Charge updated successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Charge not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<RemittanceChargeCommissionResponse>> update(
            @PathVariable String id,
            @Valid @RequestBody RemittanceChargeCommissionRequest request) {

        RemittanceChargeCommissionModel model =
                objectMapper.convertValue(request, RemittanceChargeCommissionModel.class);

        RemittanceChargeCommissionResponse response = service.update(id, model);

        return ResponseUtil.success("Charge updated successfully", response, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete Remittance Charge", description = "Delete Remittance Charge Commission by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Charge deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Charge not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<String>> delete(@PathVariable String id) {

        service.delete(id);

        return ResponseUtil.success("Charge deleted successfully", "Deleted", HttpStatus.OK);
    }
}
