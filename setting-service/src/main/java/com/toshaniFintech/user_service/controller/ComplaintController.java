package com.toshaniFintech.user_service.controller;

import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.ComplaintRequest;
import com.toshaniFintech.user_service.dto.response.ComplaintResponse;
import com.toshaniFintech.user_service.service.ComplaintService;
import io.swagger.v3.oas.annotations.Operation;
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

    // ✅ CREATE
    @PostMapping("/create")
    @Operation(summary = "Create Complaint")
    public ResponseEntity<APIResponse<ComplaintResponse>> create(
            @Valid @RequestBody ComplaintRequest request) {

        return ResponseUtil.success(
                "Complaint created successfully",
                complaintService.createComplaint(request),
                HttpStatus.CREATED
        );
    }

    // ✅ GET ALL
    @GetMapping("/all")
    public ResponseEntity<APIResponse<List<ComplaintResponse>>> getAll() {
        return ResponseUtil.success(
                "Complaints fetched successfully",
                complaintService.getAllComplaints(),
                HttpStatus.OK
        );
    }

    // ✅ GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<ComplaintResponse>> getById(@PathVariable String id) {
        return ResponseUtil.success(
                "Complaint fetched successfully",
                complaintService.getComplaintById(id),
                HttpStatus.OK
        );
    }

    // ✅ UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity<APIResponse<ComplaintResponse>> update(
            @PathVariable String id,
            @Valid @RequestBody ComplaintRequest request) {

        return ResponseUtil.success(
                "Complaint updated successfully",
                complaintService.updateComplaint(id, request),
                HttpStatus.OK
        );
    }
}