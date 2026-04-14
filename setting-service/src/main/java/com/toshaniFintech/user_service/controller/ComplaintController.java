package com.toshaniFintech.user_service.controller;

import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.ComplaintRequest;
import com.toshaniFintech.user_service.dto.response.ComplaintResponse;
import com.toshaniFintech.user_service.service.ComplaintService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/complaints")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;
    @GetMapping("/all")
    @Operation(
            summary = "Complaints List",
            description = "To Fetch Complaints List"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fetch Complaints successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "Complaints already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    public ResponseEntity<APIResponse<List<ComplaintResponse>>> getAllComplaints() {
        return ResponseUtil.success(
                "Complaints fetched successfully",
                complaintService.getAllComplaints(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get Complaints By ID",
            description = "To Fetch Complaints By ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Complaints fetched successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "Complaints already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<ComplaintResponse>> getComplaintById(@PathVariable String id) {
        return ResponseUtil.success(
                "Complaint fetched successfully",
                complaintService.getComplaintById(id),
                HttpStatus.OK
        );
    }
    @PutMapping("/update/{id}")
    @Operation(
            summary = "Update Complaints List",
            description = "To Update an Existing Complaints List"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Complaints Updated successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "Complaints already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<ComplaintResponse>> updateComplaints(
            @PathVariable String id,
            @Valid @RequestBody ComplaintRequest complaintsRequest) {
        return ResponseUtil.success(
                "Complaints updated successfully",
                complaintService.updateComplaint(id, complaintsRequest),
                HttpStatus.OK
        );
    }
}

