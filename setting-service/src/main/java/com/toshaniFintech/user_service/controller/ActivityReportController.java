package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.ActivityReportRequest;
import com.toshaniFintech.user_service.dto.response.ActivityReportResponse;
import com.toshaniFintech.user_service.service.ActivityReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/activity-report")
@Tag(name = "Activity Report API", description = "APIs for Activity Report CRUD")
public class ActivityReportController {
    @Autowired
    private ActivityReportService activityReportService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/all")
    @Operation(summary = "Activity Report", description = "Get Activity Report with pagination and advanced filter")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Activity Report fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"), @ApiResponse(responseCode = "500",
            description = "Internal server error")})
    public ResponseEntity<PaginatedResponse<ActivityReportResponse>> fetchActivityReport
            (@Valid @RequestBody ActivityReportRequest activityReportRequest) {
        return new ResponseEntity<>(activityReportService.fetchActivityReport(activityReportRequest), HttpStatus.OK);
    }
}
