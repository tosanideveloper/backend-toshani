package com.toshaniFintech.user_service.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.FundRequestRequest;
import com.toshaniFintech.user_service.dto.response.FundRequestResponse;
import com.toshaniFintech.user_service.service.FundRequestService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fund-request")
@Tag(name="FundRequest API", description = "APIs for FundTransfers CRUD")
public class FundRequestController {
    @Autowired
    private FundRequestService fundRequestService;
    @GetMapping("/all")
    public ResponseEntity<APIResponse<List<FundRequestResponse>>> getAllFundRequest() {
        return ResponseUtil.success(
                "FundRequest fetched successfully",
                fundRequestService.getAllFundRequests(),
                HttpStatus.OK
        );
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<APIResponse<FundRequestResponse>> updateFundRequest(
            @PathVariable String id,
            @Valid @RequestBody FundRequestRequest fundRequestRequest) {
        return ResponseUtil.success(
                "FundRequest updated successfully",
                fundRequestService.updateFundRequest(id, fundRequestRequest),
                HttpStatus.OK
        );
    }

}
