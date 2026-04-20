package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.CreditCardChargeCommissionGetRequestDTO;
import com.toshaniFintech.user_service.dto.request.CreditCardChargeCommissionRequestDTO;
import com.toshaniFintech.user_service.dto.response.CreditCardChargeCommissionResponseDTO;
import com.toshaniFintech.user_service.model.CreditCardChargeCommissionModel;
import com.toshaniFintech.user_service.service.CreditCardChargeCommissionService;
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
@RequestMapping("api/v1/creditcard-charge-commission")
@Tag(name = "Credit Card Charge Commission API", description = "APIs for Credit Card Charge Commission")
public class CreditCardChargeCommissionController {

    @Autowired
    private CreditCardChargeCommissionService service;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/create")
    @Operation(summary = "Create Credit Card Charge", description = "Create credit card charge commission")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Charge created successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<CreditCardChargeCommissionResponseDTO>> create(
            @Valid @RequestBody CreditCardChargeCommissionRequestDTO requestDTO) {

        CreditCardChargeCommissionModel model =
                objectMapper.convertValue(requestDTO, CreditCardChargeCommissionModel.class);

        CreditCardChargeCommissionModel saved = service.create(model);

        CreditCardChargeCommissionResponseDTO response =
                objectMapper.convertValue(saved, CreditCardChargeCommissionResponseDTO.class);

        return ResponseUtil.success("Charge created successfully", response, HttpStatus.OK);
    }

    @PostMapping("/get")
    @Operation(summary = "Get Credit Card Charges", description = "Get credit card charge commission with pagination and search")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Charges fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<PaginatedResponse<CreditCardChargeCommissionResponseDTO>> fetchCreditCardChargeCommission(
            @Valid @RequestBody CreditCardChargeCommissionGetRequestDTO requestDTO) {

        return new ResponseEntity<>(service.fetchCreditCardChargeCommission(requestDTO), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    @Operation(summary = "Get Credit Card Charge by ID", description = "Fetch single charge by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Charge fetched successfully"),
            @ApiResponse(responseCode = "404", description = "Charge not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<CreditCardChargeCommissionResponseDTO>> getById(
            @PathVariable String id) {

        CreditCardChargeCommissionResponseDTO response = service.getById(id);

        return ResponseUtil.success("Charge fetched successfully", response, HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    @Operation(summary = "Update Credit Card Charge", description = "Update credit card charge commission")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Charge updated successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Charge not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<CreditCardChargeCommissionResponseDTO>> update(
            @PathVariable String id,
            @Valid @RequestBody CreditCardChargeCommissionRequestDTO requestDTO) {

        CreditCardChargeCommissionModel model =
                objectMapper.convertValue(requestDTO, CreditCardChargeCommissionModel.class);

        CreditCardChargeCommissionResponseDTO response = service.update(id, model);

        return ResponseUtil.success("Charge updated successfully", response, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete Credit Card Charge", description = "Delete credit card charge commission by ID")
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