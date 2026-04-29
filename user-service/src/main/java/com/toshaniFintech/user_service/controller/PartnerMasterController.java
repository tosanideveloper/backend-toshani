package com.toshaniFintech.user_service.controller;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.PartnerMasterRequest;
import com.toshaniFintech.user_service.dto.response.PartnerMasterResponse;
import com.toshaniFintech.user_service.service.PartnerMasterService;
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
@RequestMapping("api/v1/partners")
@Tag(name = "Partner Master API", description = "APIs for Partner Master")
public class PartnerMasterController {

    @Autowired
    private PartnerMasterService service;

    @PostMapping("/all")
    @Operation(summary = "Partner List", description = "Get Partner list with pagination & filter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Server error")
    })
    public ResponseEntity<PaginatedResponse<PartnerMasterResponse>> fetchPartners(
            @Valid @RequestBody PartnerMasterRequest request) {

        return new ResponseEntity<>(service.fetchPartners(request), HttpStatus.OK);
    }
}
