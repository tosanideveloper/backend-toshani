package com.toshaniFintech.user_service.controller;

import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.model.CallBackLogModel;
import com.toshaniFintech.user_service.model.MerchantBankAccModel;
import com.toshaniFintech.user_service.service.CallBackLogService;
import com.toshaniFintech.user_service.service.MerchantBankAccountService;
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
@RequestMapping("/api/v1/callback")
@Tag(name = "Call Back log API", description = "APIs for Call Back Log")
public class CallBackLogController {

    @Autowired
    private CallBackLogService callBackLogService;


    @GetMapping("/all")
    @Operation(
            summary = "Call Back Log",
            description = "get a call back log"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Call back log fetched successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "User already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<List<CallBackLogModel>>> getCallBackLog() {
        return ResponseUtil.success("Call back log fetched successfully", callBackLogService.getCallBackLog(), HttpStatus.OK);
    }
}
