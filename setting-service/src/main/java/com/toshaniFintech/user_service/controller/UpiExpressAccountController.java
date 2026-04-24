package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.UpiExpressAccountRequestDTO;
import com.toshaniFintech.user_service.dto.response.UpiExpressAccountResponseDTO;
import com.toshaniFintech.user_service.model.UpiExpressAccountModel;
import com.toshaniFintech.user_service.service.UpiExpressAccountService;

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
@RequestMapping("api/v1/upiexpress-account-commission")
@Tag(name = "UPI Express Account Limit API", description = "APIs for managing UPI Express account limits")
public class UpiExpressAccountController {

    @Autowired
    private UpiExpressAccountService service;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/create")
    @Operation(summary = "Create Account Limit", description = "Create UPI Express account limit")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account created successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<UpiExpressAccountResponseDTO>> create(
            @Valid @RequestBody UpiExpressAccountRequestDTO dto) {

        UpiExpressAccountModel model =
                objectMapper.convertValue(dto, UpiExpressAccountModel.class);

        UpiExpressAccountModel saved = service.create(model);

        UpiExpressAccountResponseDTO response =
                objectMapper.convertValue(saved, UpiExpressAccountResponseDTO.class);

        return ResponseUtil.success("Account created successfully", response, HttpStatus.OK);
    }

    @PostMapping("/all")
    @Operation(summary = "Get Account Limits",
            description = "Fetch account limits with pagination and advanced search")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Data fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<PaginatedResponse<UpiExpressAccountResponseDTO>> getAll(
            @Valid @RequestBody UpiExpressAccountRequestDTO dto) {

        return new ResponseEntity<>(service.getAll(dto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Account by ID", description = "Fetch account limit by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Data fetched successfully"),
            @ApiResponse(responseCode = "404", description = "Account not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<UpiExpressAccountResponseDTO>> getById(
            @PathVariable String id) {

        return ResponseUtil.success("Fetched successfully", service.getById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update Account Limit", description = "Update UPI Express account limit")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid data"),
            @ApiResponse(responseCode = "404", description = "Account not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<UpiExpressAccountResponseDTO>> update(
            @PathVariable String id,
            @Valid @RequestBody UpiExpressAccountRequestDTO dto) {

        UpiExpressAccountModel model =
                objectMapper.convertValue(dto, UpiExpressAccountModel.class);

        return ResponseUtil.success("Updated successfully", service.update(id, model), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete Account Limit", description = "Delete account by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Account not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<String>> delete(@PathVariable String id) {

        service.delete(id);
        return ResponseUtil.success("Deleted successfully", "Success", HttpStatus.OK);
    }
}