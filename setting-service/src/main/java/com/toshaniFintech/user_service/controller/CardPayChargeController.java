package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.CardPayChargeRequestDTO;
import com.toshaniFintech.user_service.dto.response.CardPayChargeResponseDTO;
import com.toshaniFintech.user_service.model.CardPayChargeModel;
import com.toshaniFintech.user_service.service.CardPayChargeService;

import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.responses.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/cardpay-charge-commission")
@Tag(name = "Card Pay Charge API", description = "APIs for Card Pay charge slabs")
public class CardPayChargeController {

    @Autowired
    private CardPayChargeService service;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/create")
    @Operation(summary = "Create Charge", description = "Create card pay charge slab")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    })
    public ResponseEntity<APIResponse<CardPayChargeResponseDTO>> create(
            @Valid @RequestBody CardPayChargeRequestDTO dto) {

        CardPayChargeModel model = objectMapper.convertValue(dto, CardPayChargeModel.class);
        CardPayChargeModel saved = service.create(model);

        return ResponseUtil.success("Created successfully",
                objectMapper.convertValue(saved, CardPayChargeResponseDTO.class),
                HttpStatus.OK);
    }

    @PostMapping("/all")
    @Operation(summary = "Get Charges", description = "Pagination + advanced filter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fetched successfully"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    })
    public ResponseEntity<PaginatedResponse<CardPayChargeResponseDTO>> getAll(
            @Valid @RequestBody CardPayChargeRequestDTO dto) {

        return new ResponseEntity<>(service.getAll(dto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get by ID")
    public ResponseEntity<APIResponse<CardPayChargeResponseDTO>> getById(@PathVariable String id) {

        return ResponseUtil.success("Fetched", service.getById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update Charge")
    public ResponseEntity<APIResponse<CardPayChargeResponseDTO>> update(
            @PathVariable String id,
            @Valid @RequestBody CardPayChargeRequestDTO dto) {

        CardPayChargeModel model = objectMapper.convertValue(dto, CardPayChargeModel.class);

        return ResponseUtil.success("Updated", service.update(id, model), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete Charge")
    public ResponseEntity<APIResponse<String>> delete(@PathVariable String id) {

        service.delete(id);
        return ResponseUtil.success("Deleted", "Success", HttpStatus.OK);
    }
}