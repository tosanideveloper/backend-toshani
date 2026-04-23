package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.AppConstant;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.DmtChargeCommissionRequest;
import com.toshaniFintech.user_service.dto.response.DmtChargeCommissionResponse;
import com.toshaniFintech.user_service.service.DmtChargeCommissionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(" /api/v1/dmt-charge-commission")
@Tag(name = " Dmt Charge Commission Service API", description = "APIs for Dmt Charge Commission Commission Service CRUD")
public class DmtChargeCommissionController {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private DmtChargeCommissionService dmtChargeCommissionService;

    @PostMapping("/create")
    public ResponseEntity<APIResponse<DmtChargeCommissionResponse>> createDmtChargeCommission(
            @Valid @RequestBody DmtChargeCommissionRequest request) {
        return ResponseUtil.success(
                "Dmt Charge Commission created successfully",
                dmtChargeCommissionService.createDmtChargeCommission(request),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/all")
    public ResponseEntity<APIResponse<PaginatedResponse<DmtChargeCommissionResponse>>> getAllDmtChargeCommission(
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

        PaginatedResponse<DmtChargeCommissionResponse> response =
                dmtChargeCommissionService.getAllDmtChargeCommission(pageRequest);

        return ResponseUtil.success(
                "Dmt Charge Commission fetched successfully",
                response,
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<DmtChargeCommissionResponse>> getDmtChargeCommissionById(@PathVariable String id) {
        return ResponseUtil.success(
                "Dmt Charge Commission fetched successfully",
                dmtChargeCommissionService.getDmtChargeCommissionById(id),
                HttpStatus.OK
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<APIResponse<DmtChargeCommissionResponse>> updateDmtChargeCommission(
            @PathVariable String id,
            @Valid @RequestBody DmtChargeCommissionRequest dmtChargeCommissionRequest) {
        return ResponseUtil.success(
                "Dmt Charge Commission updated successfully",
                dmtChargeCommissionService.updateDmtChargeCommission(id, dmtChargeCommissionRequest),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<APIResponse<Object>> deleteDmtChargeCommission(@PathVariable String id) {
        dmtChargeCommissionService.deleteDmtChargeCommission(id);
        return ResponseUtil.success(
                "Dmt Charge Commission deleted successfully",
                null,
                HttpStatus.OK
        );
    }
}
