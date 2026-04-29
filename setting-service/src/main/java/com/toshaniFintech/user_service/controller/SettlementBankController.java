package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.SettlementBankRequestDTO;
import com.toshaniFintech.user_service.dto.response.SettlementBankResponseDTO;
import com.toshaniFintech.user_service.model.SettlementBankModel;
import com.toshaniFintech.user_service.service.SettlementBankService;

import io.swagger.v3.oas.annotations.Operation;
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
@RequestMapping("/api/v1/settlement-bank")
@Tag(name = "Settlement Bank API", description = "APIs for Settlement Bank operations")
public class SettlementBankController {

    @Autowired
    private SettlementBankService settlementBankService;

    @Autowired
    private ObjectMapper objectMapper;

    // ✅ CREATE
    @PostMapping("/create")
    @Operation(summary = "Create Settlement Bank", description = "Create new Settlement Bank entry")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<SettlementBankResponseDTO>> createSettlementBank(
            @Valid @RequestBody SettlementBankRequestDTO request) {

        SettlementBankModel model = objectMapper.convertValue(request, SettlementBankModel.class);

        SettlementBankModel saved = settlementBankService.createSettlementBank(model);

        // 🔥 Wrap into LIST (as per your required response)
        SettlementBankResponseDTO responseDTO = new SettlementBankResponseDTO();
        responseDTO.setId(saved.getId());
        responseDTO.setDate(saved.getDate());
        responseDTO.setSettlementBankModel(List.of(saved));

        return ResponseUtil.success(
                "Settlement Bank created successfully",
                responseDTO,
                HttpStatus.OK
        );
    }

    // ✅ GET ALL
    @GetMapping("/all")
    @Operation(summary = "Get All Settlement Banks", description = "Fetch all settlement bank records")
    public ResponseEntity<APIResponse<List<SettlementBankModel>>> getAllSettlementBanks() {

        List<SettlementBankModel> list = settlementBankService.getAllSettlementBanks();

        return ResponseUtil.success(
                "Settlement Banks fetched successfully",
                list,
                HttpStatus.OK
        );
    }

    // ✅ GET BY ID
    @GetMapping("/{id}")
    @Operation(summary = "Get Settlement Bank by ID", description = "Fetch settlement bank by ID")
    public ResponseEntity<APIResponse<SettlementBankModel>> getById(@PathVariable String id) {

        SettlementBankModel model = settlementBankService.getSettlementBankByID(id);

        return ResponseUtil.success(
                "Settlement Bank fetched successfully",
                model,
                HttpStatus.OK
        );
    }

    // ✅ UPDATE
    @PutMapping("/update/{id}")
    @Operation(summary = "Update Settlement Bank", description = "Update existing settlement bank")
    public ResponseEntity<APIResponse<SettlementBankResponseDTO>> updateSettlementBank(
            @PathVariable String id,
            @Valid @RequestBody SettlementBankRequestDTO request) {

        SettlementBankModel model = objectMapper.convertValue(request, SettlementBankModel.class);

        SettlementBankModel updated = settlementBankService.updateSettlementBank(id, model);

        SettlementBankResponseDTO responseDTO = new SettlementBankResponseDTO();
        responseDTO.setId(updated.getId());
        responseDTO.setDate(updated.getDate());
        responseDTO.setSettlementBankModel(List.of(updated));

        return ResponseUtil.success(
                "Settlement Bank updated successfully",
                responseDTO,
                HttpStatus.OK
        );
    }

    // ✅ DELETE (SOFT DELETE)
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete Settlement Bank", description = "Soft delete settlement bank")
    public ResponseEntity<APIResponse<Object>> deleteSettlementBank(@PathVariable String id) {

        settlementBankService.deleteSettlementBank(id);

        return ResponseUtil.success(
                "Settlement Bank deleted successfully",
                null,
                HttpStatus.OK
        );
    }
}