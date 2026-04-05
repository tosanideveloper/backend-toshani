package com.toshaniFintech.user_service.controller;

import com.toshaniFintech.user_service.dto.request.CreateIpRequest;
import com.toshaniFintech.user_service.dto.response.APIResponse;
import com.toshaniFintech.user_service.dto.response.CreateIpResponse;
import com.toshaniFintech.user_service.model.IPAddressModel;
import com.toshaniFintech.user_service.service.IPService;
import com.toshaniFintech.user_service.util.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ip")
@Tag(name = " API IP List", description = "APIs for IP List CRUD" )
public class IPController {

    @Autowired
    private IPService iPService;

    @PostMapping("/create")
    @Operation(
            summary = "Create User",
            description = "Creates a new user in the system"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User created successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "User already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<CreateIpResponse>> createIpResponseResponseEntity(
            @Valid @RequestBody CreateIpRequest createIpRequest) {

        return ResponseUtil.success(
                "IP created successfully",
                iPService.createIpResponse(createIpRequest),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/get-all")
    public ResponseEntity<APIResponse<List<IPAddressModel>>> getIpList() {
        return ResponseUtil.success(
                "IP fetched successfully",
                iPService.getIpList(),
                HttpStatus.OK
        );
    }
    @GetMapping("/get{id}")
    public ResponseEntity<APIResponse<IPAddressModel>> getIpListById(@PathVariable String id) {
        return ResponseUtil.success(
                "IP fetched successfully",
                iPService.getIpListById(id),
                HttpStatus.OK
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<APIResponse<CreateIpResponse>> updateIpAddress(
            @PathVariable Long id,
            @Valid @RequestBody CreateIpRequest request) {

        return ResponseUtil.success(
                "IP updated successfully",
                iPService.createIpResponse(request),
                HttpStatus.OK
        );
    }
}