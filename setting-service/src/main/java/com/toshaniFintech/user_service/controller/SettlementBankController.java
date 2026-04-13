package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.SettlementBankRequestDTO;
import com.toshaniFintech.user_service.dto.response.SettlementBankResponseDTO;
import com.toshaniFintech.user_service.model.SettlementBankModel;
import com.toshaniFintech.user_service.service.SettlementBankService;
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

import java.util.List;

@RestController
@RequestMapping("/api/v1/settlemt-bank")
@Tag(name = "Settlement bank API", description = "APIs for Settlement banks CRUD")
public class SettlementBankController {

    @Autowired
    private SettlementBankService settlementBankService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/create")
    @Operation(
            summary = "Settlement Bank",
            description = "Create a API for Settlement Bank"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Settlement Bank created successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "User already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<SettlementBankResponseDTO>> createSettlementBank(@Valid @RequestBody SettlementBankRequestDTO settlementBankRequestDTO) {
        SettlementBankModel settlementBankModel = objectMapper.convertValue(settlementBankRequestDTO, SettlementBankModel.class);
        SettlementBankModel updatedModel = settlementBankService.createSettlementBank( settlementBankModel);
        SettlementBankResponseDTO responseDTO = objectMapper.convertValue(updatedModel, SettlementBankResponseDTO.class);
        return ResponseUtil.success("Settlement Bank created successfully", responseDTO, HttpStatus.OK);
    }

    @GetMapping("/all")
    @Operation(
            summary = "Settlement Bank",
            description = "fetch all Settlement Bank"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Settlement Bank fetched successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "User already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    public ResponseEntity<APIResponse<List<SettlementBankModel>>> getSettlementBanks() {
        return ResponseUtil.success("Settlement Bank fetched successfully", settlementBankService.getAllSettlementBanks(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Settlement Bank",
            description = "Get Settlement Bank by ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Settlement Bank fetched successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "User already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<SettlementBankModel>> getSettlementBankByID(@PathVariable String id) {
        return ResponseUtil.success("Settlement Bank fetched successfully", settlementBankService.getSettlementBankByID(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @Operation(
            summary = "Settlement Bank",
            description = "Update Settlement Bank by id"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Settlement Bank updated successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "User already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<SettlementBankResponseDTO>> updateSettlementBank(@PathVariable String id, @Valid @RequestBody SettlementBankRequestDTO settlementBankRequestDTO) {
        SettlementBankModel settlementBankModel = objectMapper.convertValue(settlementBankRequestDTO, SettlementBankModel.class);
        SettlementBankModel updatedModel = settlementBankService.updateSettlementBank(id, settlementBankModel);
        SettlementBankResponseDTO responseDTO = objectMapper.convertValue(updatedModel, SettlementBankResponseDTO.class);
        return ResponseUtil.success("Settlement Bank updated successfully", responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(
            summary = "Settlement Bank",
            description = "Delete Settlement Bank"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Settlement Bank deleted successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "User already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })    public ResponseEntity<APIResponse<Object>> deleteSettlementBank(@PathVariable String id) {
        settlementBankService.deleteSettlementBank(id);
        return ResponseUtil.success("Settlement Bank deleted successfully", null, HttpStatus.OK);
    }

}
