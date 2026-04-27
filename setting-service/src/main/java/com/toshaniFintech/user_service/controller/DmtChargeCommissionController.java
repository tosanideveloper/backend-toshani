package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.DmtChargeCommissionGetRequest;
import com.toshaniFintech.user_service.dto.request.DmtChargeCommissionRequest;
import com.toshaniFintech.user_service.dto.response.DmtChargeCommissionResponse;
import com.toshaniFintech.user_service.model.DmtChargeCommissionModel;
import com.toshaniFintech.user_service.service.DmtChargeCommissionService;
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
@RequestMapping(" /api/v1/dmt-charge-commission")
@Tag(name = " Dmt Charge Commission Service API", description = "APIs for Dmt Charge Commission Commission Service CRUD")
public class DmtChargeCommissionController {
    @Autowired
    private DmtChargeCommissionService service;

    @Autowired
    private ObjectMapper objectMapper;


    @PostMapping("/create")
    @Operation(summary = "Create Dmt Charge Commission", description = "Create Dmt Charge Commission ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Charge created successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<DmtChargeCommissionResponse>> create(
            @Valid @RequestBody DmtChargeCommissionRequest request) {

        DmtChargeCommissionModel model =
                objectMapper.convertValue(request, DmtChargeCommissionModel.class);

        DmtChargeCommissionModel saved = service.create(model);

        DmtChargeCommissionResponse response =
                objectMapper.convertValue(saved, DmtChargeCommissionResponse.class);

        return ResponseUtil.success("Charge created successfully", response, HttpStatus.OK);
    }

    @PostMapping("/all")
    @Operation(summary = "Get Dmt Commission Charges",
            description = "Get Dmt charge commission with pagination and search")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Charges fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<PaginatedResponse<DmtChargeCommissionResponse>> fetchDmtChargeCommission(
            @Valid @RequestBody DmtChargeCommissionGetRequest request) {

        return new ResponseEntity<>(service.fetchDmtChargeCommission(request), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    @Operation(summary = "Get Dmt Commission Charge by ID", description = "Fetch single charge by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Charge fetched successfully"),
            @ApiResponse(responseCode = "404", description = "Charge not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<DmtChargeCommissionResponse>> getById(
            @PathVariable String id) {

        DmtChargeCommissionResponse response = service.getById(id);

        return ResponseUtil.success("Charge fetched successfully", response, HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    @Operation(summary = "Update Dmt Commission Charge", description = "Update Dmt Charge Commission")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Charge updated successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Charge not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<DmtChargeCommissionResponse>> update(
            @PathVariable String id,
            @Valid @RequestBody DmtChargeCommissionRequest request) {

        DmtChargeCommissionModel model =
                objectMapper.convertValue(request, DmtChargeCommissionModel.class);

        DmtChargeCommissionResponse response = service.update(id, model);

        return ResponseUtil.success("Charge updated successfully", response, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete Dmt Commission Charge", description = "Delete Dmt Charge Commission by ID")
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
