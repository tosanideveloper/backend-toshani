package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.user_service.dto.request.ApisServicesRequestDTO;
import com.toshaniFintech.user_service.dto.response.APIResponse;
import com.toshaniFintech.user_service.dto.response.ApiPartnerServiceResponseDTO;
import com.toshaniFintech.user_service.model.ApiPartnerServiceModel;
import com.toshaniFintech.user_service.service.ApiPartnerService;
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
@RequestMapping("/api/v1/api-service")
@Tag(name = "Api Partner Service API", description = "APIs for Manage API Partner Service CRUD")
public class ApiPartnerServiceController {
    @Autowired
    private ApiPartnerService apiPartnerService;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/all")
    @Operation(
            summary = "API partner service",
            description = "This api is to fetch API Partner Service Details"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "API Partner Services fetched successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "Data does not exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<List<ApiPartnerServiceModel>>> getAllSettlementTime() {
        return ResponseUtil.success("API Partner Services fetched successfully", apiPartnerService.getAllApiPartnerServices(), HttpStatus.OK);
    }
    @PostMapping("/create")
    @Operation(
            summary = "API partner service",
            description = "This api is to Create API Partner Service"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "API Partner Services created successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "Data does not exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<ApiPartnerServiceResponseDTO>> createPartner(@Valid @RequestBody ApisServicesRequestDTO apisServicesRequestDto) {
        ApiPartnerServiceModel apiPartnerServiceModel = objectMapper.convertValue(apisServicesRequestDto, ApiPartnerServiceModel.class);
        ApiPartnerServiceModel partnerServiceModel = apiPartnerService.createApisPartnerService(apiPartnerServiceModel);
        ApiPartnerServiceResponseDTO responseDTO = objectMapper.convertValue(partnerServiceModel, ApiPartnerServiceResponseDTO.class);
        return ResponseUtil.success("API Partner Services created successfully", responseDTO, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    @PostMapping("/create")
    @Operation(
            summary = "API partner service",
            description = "This api is to Delete API Partner Service"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "API Partner Services deleted successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "Data does not exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<Object>> deletePartner(@PathVariable String id) {
        apiPartnerService.deleteApiPartnerService(id);
        return ResponseUtil.success("API Partner Services deleted successfully", null, HttpStatus.OK);
    }

}
