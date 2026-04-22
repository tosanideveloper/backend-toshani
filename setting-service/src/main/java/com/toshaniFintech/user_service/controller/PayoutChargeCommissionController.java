package com.toshaniFintech.user_service.controller;

import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.AppConstant;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.PayoutChargeCommissionRequest;
import com.toshaniFintech.user_service.dto.response.PayoutChargeCommissionResponse;
import com.toshaniFintech.user_service.service.PayoutChargeCommissionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(" /api/v1/payout-charge-commission")
@Tag(name = " Payout Charge Commission Service API", description = "APIs for Manage Payout Charge Commission Service CRUD")
public class PayoutChargeCommissionController {
    @Autowired
    private PayoutChargeCommissionService payoutChargeCommissionService;

    @PostMapping("/create")
    public ResponseEntity<APIResponse<PayoutChargeCommissionResponse>> createPayoutChargeCommission(
            @Valid @RequestBody PayoutChargeCommissionRequest request) {
        return ResponseUtil.success("Payout Charge Commission created successfully",
                payoutChargeCommissionService.createPayoutChargeCommission(request),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<PayoutChargeCommissionResponse>>
    getPayoutChargeCommissionById(@PathVariable String id) {
        return ResponseUtil.success(
                "Payout Charge Commission fetched successfully",
                payoutChargeCommissionService.getPayoutChargeCommissionById(id),
                HttpStatus.OK
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<APIResponse<PayoutChargeCommissionResponse>>
    updatePayoutChargeCommission(@PathVariable String id,
                                 @Valid @RequestBody PayoutChargeCommissionRequest payoutChargeCommissionRequest) {
        return ResponseUtil.success(
                "Payout Charge Commission updated successfully",
                payoutChargeCommissionService.updatePayoutChargeCommission(id, payoutChargeCommissionRequest),
                HttpStatus.OK
        );
    }
    @GetMapping("/all")
    public ResponseEntity<APIResponse<PaginatedResponse<PayoutChargeCommissionResponse>>> getAllPayoutChargeCommission(
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

        PaginatedResponse<PayoutChargeCommissionResponse> response =
                payoutChargeCommissionService.getAllPayoutChargeCommission(pageRequest);

        return ResponseUtil.success(
                "Payout Charge Commission fetched successfully",
                response,
                HttpStatus.OK
        );
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<APIResponse<Object>> deletePayoutChargeCommission(@PathVariable String id) {
        payoutChargeCommissionService.deletePayoutChargeCommission(id);
        return ResponseUtil.success(
                "Payout Charge Commission deleted successfully",
                null,
                HttpStatus.OK
        );
    }

}

