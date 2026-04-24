package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.ExpressUpiChargeRequestDTO;
import com.toshaniFintech.user_service.dto.response.ExpressUpiChargeResponseDTO;
import com.toshaniFintech.user_service.model.ExpressUpiChargeModel;
import com.toshaniFintech.user_service.service.ExpressUpiChargeService;

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
@RequestMapping("api/v1/expressupi-charge-commission")
@Tag(name = "Express UPI Charge API", description = "APIs for Express UPI charge slabs")
public class ExpressUpiChargeController {

    @Autowired
    private ExpressUpiChargeService service;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/create")
    @Operation(summary = "Create Charge", description = "Create Express UPI charge slab")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Charge created successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<ExpressUpiChargeResponseDTO>> create(
            @Valid @RequestBody ExpressUpiChargeRequestDTO dto) {

        ExpressUpiChargeModel model =
                objectMapper.convertValue(dto, ExpressUpiChargeModel.class);

        ExpressUpiChargeModel saved = service.create(model);

        ExpressUpiChargeResponseDTO response =
                objectMapper.convertValue(saved, ExpressUpiChargeResponseDTO.class);

        return ResponseUtil.success("Charge created successfully", response, HttpStatus.OK);
    }

    @PostMapping("/all")
    @Operation(summary = "Get Charges",
            description = "Fetch Express UPI charges with pagination and advanced filter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Charges fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<PaginatedResponse<ExpressUpiChargeResponseDTO>> getAll(
            @Valid @RequestBody ExpressUpiChargeRequestDTO dto) {

        return new ResponseEntity<>(service.getAll(dto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Charge by ID", description = "Fetch charge slab by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Charge fetched successfully"),
            @ApiResponse(responseCode = "404", description = "Charge not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<ExpressUpiChargeResponseDTO>> getById(
            @PathVariable String id) {

        return ResponseUtil.success("Charge fetched successfully", service.getById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update Charge", description = "Update Express UPI charge slab")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Charge updated successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid data"),
            @ApiResponse(responseCode = "404", description = "Charge not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<ExpressUpiChargeResponseDTO>> update(
            @PathVariable String id,
            @Valid @RequestBody ExpressUpiChargeRequestDTO dto) {

        ExpressUpiChargeModel model =
                objectMapper.convertValue(dto, ExpressUpiChargeModel.class);

        return ResponseUtil.success("Charge updated successfully", service.update(id, model), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete Charge", description = "Delete charge slab by ID")
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