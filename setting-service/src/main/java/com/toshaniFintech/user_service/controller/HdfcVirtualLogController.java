package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.HdfcVirtualLogRequest;
import com.toshaniFintech.user_service.dto.response.HdfcVirtualLogResponse;
import com.toshaniFintech.user_service.service.HdfcVirtualLogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/Hdfc_virtual_log")
@Tag(name = "Hdfc Virtual Log Service API", description = "APIs for Manage Hdfc Virtual Log Service CRUD")
public class HdfcVirtualLogController {
    @Autowired
    public HdfcVirtualLogService hdfcVirtualLogService;
    @Autowired
    private ObjectMapper objectMapper;
    @PostMapping("/all")
    @Operation(summary = "Hdfc Virtual Log",
            description = "Get Hdfc Virtual Log with pagination and advanced filter")
    @ApiResponses(value = {@ApiResponse(responseCode = "200",
            description = "Hdfc Virtual Log fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<PaginatedResponse<HdfcVirtualLogResponse>> fetchHdfcVirtualLog
            (@Valid @RequestBody HdfcVirtualLogRequest hdfcVirtualLogRequest) {

        return new ResponseEntity<>(hdfcVirtualLogService.fetchHdfcVirtualLog
                (hdfcVirtualLogRequest), HttpStatus.OK);
    }
}
