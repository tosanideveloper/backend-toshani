package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.UpiLiteChargeRequestDTO;
import com.toshaniFintech.user_service.dto.response.UpiLiteChargeResponseDTO;
import com.toshaniFintech.user_service.model.UpiLiteChargeModel;
import com.toshaniFintech.user_service.service.UpiLiteChargeService;

import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.responses.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/upilite-charge-commission")
@Tag(name = "UPI Lite Charge API", description = "APIs for UPI Lite charge slabs")
public class UpiLiteChargeController {

    @Autowired
    private UpiLiteChargeService upiLiteChargeService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/create")
    @Operation(summary = "Create UPI Lite Charge", description = "Create new charge slab")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    })
    public ResponseEntity<APIResponse<UpiLiteChargeResponseDTO>> create(
            @Valid @RequestBody UpiLiteChargeRequestDTO dto) {

        UpiLiteChargeModel model = objectMapper.convertValue(dto, UpiLiteChargeModel.class);
        UpiLiteChargeModel saved = upiLiteChargeService.create(model);

        return ResponseUtil.success("Created successfully",
                objectMapper.convertValue(saved, UpiLiteChargeResponseDTO.class),
                HttpStatus.OK);
    }

    @PostMapping("/all")
    @Operation(summary = "Get Charges", description = "Fetch with pagination and filter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fetched successfully"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    })
    public ResponseEntity<PaginatedResponse<UpiLiteChargeResponseDTO>> getAll(
            @Valid @RequestBody UpiLiteChargeRequestDTO dto) {

        return new ResponseEntity<>(upiLiteChargeService.getAll(dto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get by ID")
    public ResponseEntity<APIResponse<UpiLiteChargeResponseDTO>> getById(@PathVariable String id) {

        return ResponseUtil.success("Fetched", upiLiteChargeService.getById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update Charge")
    public ResponseEntity<APIResponse<UpiLiteChargeResponseDTO>> update(
            @PathVariable String id,
            @Valid @RequestBody UpiLiteChargeRequestDTO dto) {

        UpiLiteChargeModel model = objectMapper.convertValue(dto, UpiLiteChargeModel.class);

        return ResponseUtil.success("Updated", upiLiteChargeService.update(id, model), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete Charge")
    public ResponseEntity<APIResponse<String>> delete(@PathVariable String id) {

        upiLiteChargeService.delete(id);
        return ResponseUtil.success("Deleted", "Success", HttpStatus.OK);
    }
}