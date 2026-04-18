package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.AppConstant;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.RemittanceChargeCommissionRequest;
import com.toshaniFintech.user_service.dto.response.RemittanceChargeCommissionResponse;
import com.toshaniFintech.user_service.service.RemittanceChargeCommissionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/remittance-charge-commission")
@Tag(name = "Remittance Charge Commission Service API",
        description = "APIs for Manage Remittance Charge Commission Service CRUD")
public class RemittanceChargeCommissionController {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RemittanceChargeCommissionService remittanceChargeCommissionService;

    @PostMapping("/create")
    public ResponseEntity<APIResponse<RemittanceChargeCommissionResponse>>
    createRemittanceChargeCommission(
            @Valid @RequestBody RemittanceChargeCommissionRequest request) {
        return ResponseUtil.success(
                "Remittance Charge Commission created successfully",
                remittanceChargeCommissionService.createRemittanceChargeCommission(request),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/all")
    public ResponseEntity<APIResponse<PaginatedResponse
            <RemittanceChargeCommissionResponse>>> getAllRemittanceChargeCommission(
            @RequestParam(name = AppConstant.PAGE_NUMBER_PROPERTY_NAME,
                    defaultValue = AppConstant.PAGE_NUMBER_DEFAULT_VALUE,
                    required = false) int pageNo,

            @RequestParam(name = AppConstant.PAGE_SIZE_PROPERTY_NAME,
                    defaultValue = AppConstant.PAGE_SIZE_DEFAULT_VALUE,
                    required = false) int pageSize,

            @RequestParam(name = AppConstant.SORT_BY_PROPERTY_NAME,
                    defaultValue = AppConstant.SORT_BY_DEFAULT_VALUE,
                    required = false) String sortBy,

            @RequestParam(name = AppConstant.ORDER_TYPE_PROPERTY_NAME,
                    defaultValue = AppConstant.ORDER_TYPE_DEFAULT_VALUE,
                    required = false) String orderType,

            @RequestParam(name = AppConstant.SEARCH_PROPERTY_NAME,
                    required = false) String searchString
    ) {

        PageRequest pageRequest;

        if (AppConstant.ORDER_TYPE_DEFAULT_VALUE.equalsIgnoreCase(orderType)) {
            pageRequest = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        } else {
            pageRequest = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());
        }

        PaginatedResponse<RemittanceChargeCommissionResponse> response =
                remittanceChargeCommissionService.getAllRemittanceChargeCommission(pageRequest);

        return ResponseUtil.success(
                "Remittance Charge Commission fetched successfully",
                response,
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<RemittanceChargeCommissionResponse>>
    getRemittanceChargeCommissionById(@PathVariable String id) {
        return ResponseUtil.success(
                "Remittance Charge Commission fetched successfully",
                remittanceChargeCommissionService.getRemittanceChargeCommissionById(id),
                HttpStatus.OK
        );
    }
}
