package com.toshaniFintech.settlement.controller;

import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.AppConstant;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.settlement.dto.request.CreateSettlementRequest;
import com.toshaniFintech.settlement.dto.request.UpdateSettlementRequest;
import com.toshaniFintech.settlement.dto.response.SettlementResponse;
import com.toshaniFintech.settlement.service.SettlementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/settlement")
@Tag(name = "Settlement API", description = "APIs for managing settlement transactions (settlement_master)")
public class SettlementController {

    @Autowired
    private SettlementService settlementService;

    @Operation(summary = "Create a new settlement request", description = "Initiates a new settlement in REQUESTED status")
    @PostMapping("/create")
    public ResponseEntity<APIResponse<SettlementResponse>> createSettlement(
            @Valid @RequestBody CreateSettlementRequest request) {
        return ResponseUtil.success(
                "Settlement created successfully",
                settlementService.createSettlement(request),
                HttpStatus.CREATED
        );
    }

    @Operation(summary = "Get all settlements (paginated)", description = "Returns all settlement records with pagination support")
    @GetMapping("/all")
    public ResponseEntity<APIResponse<PaginatedResponse<SettlementResponse>>> getAllSettlements(
            @RequestParam(name = AppConstant.PAGE_NUMBER_PROPERTY_NAME, defaultValue = AppConstant.PAGE_NUMBER_DEFAULT_VALUE, required = false) int pageNo,
            @RequestParam(name = AppConstant.PAGE_SIZE_PROPERTY_NAME, defaultValue = AppConstant.PAGE_SIZE_DEFAULT_VALUE, required = false) int pageSize,
            @RequestParam(name = AppConstant.SORT_BY_PROPERTY_NAME, defaultValue = AppConstant.SORT_BY_DEFAULT_VALUE, required = false) String sortBy,
            @RequestParam(name = AppConstant.ORDER_TYPE_PROPERTY_NAME, defaultValue = AppConstant.ORDER_TYPE_DEFAULT_VALUE, required = false) String orderType) {
        return ResponseUtil.success(
                "Settlements fetched successfully",
                settlementService.getAllSettlements(pageNo, pageSize, sortBy, orderType),
                HttpStatus.OK
        );
    }

    @Operation(summary = "Get settlement by ID")
    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<SettlementResponse>> getSettlementById(@PathVariable String id) {
        return ResponseUtil.success(
                "Settlement fetched successfully",
                settlementService.getSettlementById(id),
                HttpStatus.OK
        );
    }

    @Operation(summary = "Update settlement status", description = "Used by admin to update status and attach bank RRN after payout confirmation")
    @PutMapping("/update/{id}")
    public ResponseEntity<APIResponse<SettlementResponse>> updateSettlement(
            @PathVariable String id,
            @Valid @RequestBody UpdateSettlementRequest request) {
        return ResponseUtil.success(
                "Settlement updated successfully",
                settlementService.updateSettlement(id, request),
                HttpStatus.OK
        );
    }

    @Operation(summary = "Get settlements by user UUID")
    @GetMapping("/by-user/{userUuid}")
    public ResponseEntity<APIResponse<List<SettlementResponse>>> getSettlementsByUser(
            @PathVariable String userUuid) {
        return ResponseUtil.success(
                "Settlements fetched successfully",
                settlementService.getSettlementsByUser(userUuid),
                HttpStatus.OK
        );
    }
}