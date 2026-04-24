package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.PaytmPosChargeRequestDTO;
import com.toshaniFintech.user_service.dto.response.PaytmPosChargeResponseDTO;
import com.toshaniFintech.user_service.model.PaytmPosChargeModel;
import com.toshaniFintech.user_service.service.PaytmPosChargeService;
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
@RequestMapping("api/v1/paytmpos-charge-commission")
@Tag(name = "Paytm POS Charge Commission API", description = "APIs for Paytm POS Charge Commission")
public class PaytmPosChargeController {

    @Autowired
    private PaytmPosChargeService service;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/create")
    @Operation(summary = "Create Paytm POS Charge", description = "Create Paytm POS charge commission")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Charge created successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<PaytmPosChargeResponseDTO>> create(
            @Valid @RequestBody PaytmPosChargeRequestDTO requestDTO) {

        PaytmPosChargeModel model =
                objectMapper.convertValue(requestDTO, PaytmPosChargeModel.class);

        PaytmPosChargeModel saved = service.create(model);

        PaytmPosChargeResponseDTO response =
                objectMapper.convertValue(saved, PaytmPosChargeResponseDTO.class);

        return ResponseUtil.success("Charge created successfully", response, HttpStatus.OK);
    }

    @PostMapping("/all")
    @Operation(summary = "Get Paytm POS Charges",
            description = "Get Paytm POS charge commission with pagination and search")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Charges fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<PaginatedResponse<PaytmPosChargeResponseDTO>> getAll(
            @Valid @RequestBody PaytmPosChargeRequestDTO requestDTO) {

        return new ResponseEntity<>(service.getAll(requestDTO), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Paytm POS Charge by ID", description = "Fetch single charge by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Charge fetched successfully"),
            @ApiResponse(responseCode = "404", description = "Charge not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<PaytmPosChargeResponseDTO>> getById(
            @PathVariable String id) {

        PaytmPosChargeResponseDTO response = service.getById(id);

        return ResponseUtil.success("Charge fetched successfully", response, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update Paytm POS Charge", description = "Update Paytm POS charge commission")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Charge updated successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Charge not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<PaytmPosChargeResponseDTO>> update(
            @PathVariable String id,
            @Valid @RequestBody PaytmPosChargeRequestDTO requestDTO) {

        PaytmPosChargeModel model =
                objectMapper.convertValue(requestDTO, PaytmPosChargeModel.class);

        PaytmPosChargeResponseDTO response = service.update(id, model);

        return ResponseUtil.success("Charge updated successfully", response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete Paytm POS Charge", description = "Delete Paytm POS charge commission by ID")
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