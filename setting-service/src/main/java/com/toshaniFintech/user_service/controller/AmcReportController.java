package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.response.AmcReportResponse;
import com.toshaniFintech.user_service.model.AmcReportModel;
import com.toshaniFintech.user_service.service.AmcReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/amc-report")
@Tag(name = "Amc Report Service API", description = "APIs for Manage AMC Report Service CRUD")
public class AmcReportController {
    @Autowired
    private AmcReportService amcReportService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/all")
    @Operation(
            summary = "AMC Report service",
            description = "This api is to fetch AMC Report Service Details"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "AMC Report Services fetched successfully",
                    content = @Content(schema = @Schema(implementation = AmcReportResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "Data does not exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<List<AmcReportModel>>> getAllAmcReportServices() {
        return ResponseUtil.success("AMC Report Services fetched successfully", amcReportService.
                getAllAmcReport(), HttpStatus.OK);
    }


}
