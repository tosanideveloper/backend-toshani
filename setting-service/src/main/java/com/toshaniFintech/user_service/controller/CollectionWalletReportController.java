package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.CollectionWalletReportRequest;
import com.toshaniFintech.user_service.dto.response.CollectionWalletReportResponse;
import com.toshaniFintech.user_service.service.CollectionWalletReportService;
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
@RequestMapping("api/v1/collection-wallet-report")
@Tag(name = "Collection Wallet Report Service API", description = "APIs for Manage Collection Wallet Report Service CRUD")
public class CollectionWalletReportController {
    @Autowired
    private CollectionWalletReportService collectionWalletReportService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/all")
    @Operation(summary = "Collection Wallet Report",
            description = "Get Collection Wallet Report with pagination and advanced filter")
    @ApiResponses(value = {@ApiResponse(responseCode = "200",
            description = "Collection Wallet Report fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<PaginatedResponse<CollectionWalletReportResponse>> fetchCollectionWalletReport
            (@Valid @RequestBody CollectionWalletReportRequest collectionWalletReportRequest) {

        return new ResponseEntity<>(collectionWalletReportService.fetchCollectionWalletReport
                (collectionWalletReportRequest), HttpStatus.OK);
    }
}
