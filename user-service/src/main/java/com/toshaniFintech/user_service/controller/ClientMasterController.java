package com.toshaniFintech.user_service.controller;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.ClientMasterRequest;
import com.toshaniFintech.user_service.dto.response.ClientMasterResponse;
import com.toshaniFintech.user_service.service.ClientMasterService;
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
@RequestMapping("api/v1/client-master")
@Tag(name = "Client Master API", description = "APIs for Client Master")
public class ClientMasterController {

    @Autowired
    private ClientMasterService clientMasterService;

    @PostMapping("/all")
    @Operation(
            summary = "Client Master List",
            description = "Get Client Master list with pagination and filter"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client list fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<PaginatedResponse<ClientMasterResponse>> fetchClients(
            @Valid @RequestBody ClientMasterRequest request) {

        return new ResponseEntity<>(
                clientMasterService.fetchClients(request),
                HttpStatus.OK
        );
    }
}