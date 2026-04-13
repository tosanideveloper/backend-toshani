package com.toshaniFintech.user_service.controller;

import com.toshaniFintech.user_service.dto.response.APIResponse;
import com.toshaniFintech.user_service.model.MerchantBankAccModel;
import com.toshaniFintech.user_service.service.MerchantBankAccountService;
import com.toshaniFintech.user_service.util.ResponseUtil;
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
@RequestMapping("/api/v1/api-service")
@Tag(name = "Merchant Bank Account API", description = "APIs for Merchant Bank Account CRUD")
public class MerchantBankAccController {

    @Autowired
    MerchantBankAccountService merchantBankAccountService;

    @GetMapping("/get")
    @Operation(
            summary = "Merchant Bank Account",
            description = "get a Merchant Bank Account"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Merchant Bank Account fetched successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "User already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<List<MerchantBankAccModel>>> getMerchantBankAcc() {
        return ResponseUtil.success("Merchant Bank Account fetched successfully", merchantBankAccountService.getMerchantBankAcc(), HttpStatus.OK);
    }

}
