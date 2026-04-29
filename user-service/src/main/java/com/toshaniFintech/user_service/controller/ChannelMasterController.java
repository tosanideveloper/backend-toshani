package com.toshaniFintech.user_service.controller;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.ChannelMasterFetchRequest;
import com.toshaniFintech.user_service.dto.request.ChannelMasterCreateRequest;
import com.toshaniFintech.user_service.dto.response.ChannelMasterResponse;
import com.toshaniFintech.user_service.service.ChannelMasterService;

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
@RequestMapping("/api/v1/channels")
@Tag(name = "Channel Master API", description = "APIs for Channel Master")
public class ChannelMasterController {

    @Autowired
    private ChannelMasterService service;

    @PostMapping("/create")
    @Operation(summary = "Create Channel", description = "Create new channel")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Channel created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<ChannelMasterResponse> create(
            @Valid @RequestBody ChannelMasterCreateRequest request) {

        return new ResponseEntity<>(service.create(request), HttpStatus.OK);
    }

    @PutMapping("/update/{uuid}")
    @Operation(summary = "Update Channel", description = "Update channel by UUID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Channel updated successfully"),
            @ApiResponse(responseCode = "404", description = "Channel not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<ChannelMasterResponse> update(
            @PathVariable String uuid,
            @Valid @RequestBody ChannelMasterCreateRequest request) {

        return new ResponseEntity<>(service.update(uuid, request), HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    @Operation(summary = "Get Channel", description = "Get channel by UUID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Channel fetched successfully"),
            @ApiResponse(responseCode = "404", description = "Channel not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<ChannelMasterResponse> get(
            @PathVariable String uuid) {

        return new ResponseEntity<>(service.getByUuid(uuid), HttpStatus.OK);
    }


    @PostMapping("/all")
    @Operation(summary = "Channel List", description = "Get all channels with pagination & filters")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Channels fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<PaginatedResponse<ChannelMasterResponse>> getAll(
            @Valid @RequestBody ChannelMasterFetchRequest request) {

        return new ResponseEntity<>(service.getAll(request), HttpStatus.OK);
    }
}