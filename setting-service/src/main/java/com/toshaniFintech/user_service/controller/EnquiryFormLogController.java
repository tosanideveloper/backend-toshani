package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.EnquiryFormLogRequest;
import com.toshaniFintech.user_service.dto.response.EnquiryFormLogResponse;
import com.toshaniFintech.user_service.service.EnquiryFormLogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/enquiry-form-log")
public class EnquiryFormLogController {
    @Autowired
    private EnquiryFormLogService enquiryFormLogService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/all")
    @Operation(summary = "Enquiry Form Log", description = "Get Enquiry Form Log with pagination and advanced filter")
    @ApiResponses(value = {@ApiResponse(responseCode = "200",
            description = "Enquiry Form Log fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<PaginatedResponse<EnquiryFormLogResponse>> fetchEnquiryFormLog
            (@Valid @RequestBody EnquiryFormLogRequest enquiryFormLogRequest) {

        return new ResponseEntity<>(enquiryFormLogService.fetchEnquiryFormLog(enquiryFormLogRequest), HttpStatus.OK);
    }
}
