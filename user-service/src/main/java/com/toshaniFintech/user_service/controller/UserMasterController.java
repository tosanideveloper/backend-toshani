package com.toshaniFintech.user_service.controller;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.UserMasterFetchRequestDTO;
import com.toshaniFintech.user_service.dto.request.UserMasterRequestDTO;
import com.toshaniFintech.user_service.dto.response.UserMasterResponse;
import com.toshaniFintech.user_service.service.UserMasterService;

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
@RequestMapping("/api/v1/users")
@Tag(name = "User Master API", description = "APIs for User Master")
public class UserMasterController {

    @Autowired
    private UserMasterService service;

    @PostMapping("/create")
    @Operation(summary = "Create User", description = "Create new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<UserMasterResponse> create(
            @Valid @RequestBody UserMasterRequestDTO request) {

        return new ResponseEntity<>(service.create(request), HttpStatus.OK);
    }


    @PutMapping("/update/{uuid}")
    @Operation(summary = "Update User", description = "Update user by UUID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User updated successfully"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<UserMasterResponse> update(
            @PathVariable String uuid,
            @Valid @RequestBody UserMasterRequestDTO request) {

        return new ResponseEntity<>(service.update(uuid, request), HttpStatus.OK);
    }


    @GetMapping("/{uuid}")
    @Operation(summary = "Get User", description = "Get user by UUID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User fetched successfully"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<UserMasterResponse> get(
            @PathVariable String uuid) {

        return new ResponseEntity<>(service.getByUuid(uuid), HttpStatus.OK);
    }

    @PostMapping("/all")
    @Operation(summary = "User List", description = "Get all users with pagination & filters")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Users fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<PaginatedResponse<UserMasterResponse>> getAll(
            @Valid @RequestBody UserMasterFetchRequestDTO request) {

        return new ResponseEntity<>(service.getAll(request), HttpStatus.OK);
    }
}