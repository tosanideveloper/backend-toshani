package com.toshaniFintech.user_service.controller;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.EntityMasterCreateRequest;
import com.toshaniFintech.user_service.dto.request.EntityMasterFetchRequest;
import com.toshaniFintech.user_service.dto.response.EntityMasterResponse;
import com.toshaniFintech.user_service.service.EntityMasterService;

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
@RequestMapping("/api/v1/entities")
@Tag(name = "Entity Master API", description = "APIs for Entity Master")
public class EntityMasterController {

    @Autowired
    private EntityMasterService service;

    @PostMapping("/create")
    @Operation(summary = "Create Entity", description = "Create new entity")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Entity created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<EntityMasterResponse> create(
            @Valid @RequestBody EntityMasterCreateRequest request) {

        return new ResponseEntity<>(service.create(request), HttpStatus.OK);
    }


    @PutMapping("/update/{uuid}")
    @Operation(summary = "Update Entity", description = "Update entity by UUID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Entity updated successfully"),
            @ApiResponse(responseCode = "404", description = "Entity not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<EntityMasterResponse> update(
            @PathVariable String uuid,
            @Valid @RequestBody EntityMasterCreateRequest request) {

        return new ResponseEntity<>(service.update(uuid, request), HttpStatus.OK);
    }


    @GetMapping("/{uuid}")
    @Operation(summary = "Get Entity", description = "Get entity by UUID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Entity fetched successfully"),
            @ApiResponse(responseCode = "404", description = "Entity not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<EntityMasterResponse> get(
            @PathVariable String uuid) {

        return new ResponseEntity<>(service.getByUuid(uuid), HttpStatus.OK);
    }


    @PostMapping("/all")
    @Operation(summary = "Entity List", description = "Get all entities with pagination & filters")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Entities fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<PaginatedResponse<EntityMasterResponse>> getAll(
            @Valid @RequestBody EntityMasterFetchRequest request) {

        return new ResponseEntity<>(service.getAll(request), HttpStatus.OK);
    }
}