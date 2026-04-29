package com.toshaniFintech.user_service.controller;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.HierarchyMasterCreateRequest;
import com.toshaniFintech.user_service.dto.request.HierarchyMasterFetchRequest;
import com.toshaniFintech.user_service.dto.response.HierarchyMasterResponse;
import com.toshaniFintech.user_service.service.HierarchyMasterService;

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
@RequestMapping("/api/v1/hierarchies")
@Tag(name = "Hierarchy Master API", description = "APIs for Hierarchy Master")
public class HierarchyMasterController {

    @Autowired
    private HierarchyMasterService service;

    @PostMapping("/create")
    @Operation(summary = "Create Hierarchy", description = "Create new hierarchy")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Hierarchy created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<HierarchyMasterResponse> create(
            @Valid @RequestBody HierarchyMasterCreateRequest request) {

        return new ResponseEntity<>(service.create(request), HttpStatus.OK);
    }

    @PutMapping("/update/{uuid}")
    @Operation(summary = "Update Hierarchy", description = "Update hierarchy by UUID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Hierarchy updated successfully"),
            @ApiResponse(responseCode = "404", description = "Hierarchy not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<HierarchyMasterResponse> update(
            @PathVariable String uuid,
            @Valid @RequestBody HierarchyMasterCreateRequest request) {

        return new ResponseEntity<>(service.update(uuid, request), HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    @Operation(summary = "Get Hierarchy", description = "Get hierarchy by UUID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Hierarchy fetched successfully"),
            @ApiResponse(responseCode = "404", description = "Hierarchy not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<HierarchyMasterResponse> get(
            @PathVariable String uuid) {

        return new ResponseEntity<>(service.getByUuid(uuid), HttpStatus.OK);
    }

    @PostMapping("/all")
    @Operation(summary = "Hierarchy List", description = "Get all hierarchies with pagination & filters")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Hierarchies fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<PaginatedResponse<HierarchyMasterResponse>> getAll(
            @Valid @RequestBody HierarchyMasterFetchRequest request) {

        return new ResponseEntity<>(service.getAll(request), HttpStatus.OK);
    }
}