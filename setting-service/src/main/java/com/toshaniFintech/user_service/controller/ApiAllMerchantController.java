package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.ApiAllMerchantRequestDTO;
import com.toshaniFintech.user_service.dto.request.ApisServicesRequestDTO;
import com.toshaniFintech.user_service.dto.response.ApiAllMerchantResponseDTO;
import com.toshaniFintech.user_service.dto.response.ApisServicesResponseDTO;
import com.toshaniFintech.user_service.model.ApiAllMerchantModel;
import com.toshaniFintech.user_service.model.ApisServiceModel;
import com.toshaniFintech.user_service.service.ApiAllMerchantService;
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
@RequestMapping("/api/v1/all_merchant")

@Tag(name = "API All Merchant", description = "APIs for All Merchant List CRUD")
public class ApiAllMerchantController {

    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    private ApiAllMerchantService apiAllMerchantService;

    @GetMapping("/all")
    @Operation(summary = "API All Merchant", description = "This api is to fetch All Merchant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Merchant fetched successfully",
            content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "Data does not exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<List<ApiAllMerchantModel>>> getAllApiMerchantService() {
        return ResponseUtil.success("All Merchant fetched successfully", apiAllMerchantService.getAllApiMerchantService(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "API All Merchant", description = "This api is to get All Merchant by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Merchant get by ID successfully",
            content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "User already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<ApiAllMerchantModel>> getAllApiMerchantService(@PathVariable String id) {
        return ResponseUtil.success("All Merchant get by ID successfully", apiAllMerchantService.getByID(id), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    @Operation(
            summary = "API All Merchant",
            description = "This api is to update All Merchant"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Merchant updated successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "User already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    public ResponseEntity<APIResponse<ApiAllMerchantResponseDTO>> updateSetting(@PathVariable String id, @Valid @RequestBody ApiAllMerchantRequestDTO apiAllMerchantRequestDTO) {
        ApiAllMerchantModel apiAllMerchantModel = objectMapper.convertValue(apiAllMerchantRequestDTO, ApiAllMerchantModel.class);
        ApiAllMerchantModel updatedModel = apiAllMerchantService.updateAllMerchant(id, apiAllMerchantModel);
        ApiAllMerchantResponseDTO responseDTO = objectMapper.convertValue(updatedModel, ApiAllMerchantResponseDTO.class);
        return ResponseUtil.success("Apis service updated successfully", responseDTO, HttpStatus.OK);
    }
}