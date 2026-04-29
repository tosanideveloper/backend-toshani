package com.toshaniFintech.user_service.controller;

import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.model.FingPayOnboardModel;
import com.toshaniFintech.user_service.service.FingPayOnboardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fingpay-onboard")

@Tag(name = "FingpayOnboard API", description = "APIs for FingPayOnboard CRUD")

public class FingPayOnboardController {
    @Autowired
    private FingPayOnboardService fingPayOnboardService;

    @GetMapping("/all")
    @Operation(summary = "FingPay Onboard List", description = "To fetch FingPay Onboard List")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "FingPay Onboarded list page successfully", content =
            @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<APIResponse<List<FingPayOnboardModel>>> getfingPayOnboardlist() {
        return ResponseUtil.success("FingPay Onboarded List fetched successfully",
                fingPayOnboardService.getFingPayOnboardList(), HttpStatus.OK);
    }
}
