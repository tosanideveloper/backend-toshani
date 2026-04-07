package com.toshaniFintech.user_service.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.user_service.dto.request.ApisServicesRequestDTO;
import com.toshaniFintech.user_service.dto.response.APIResponse;
import com.toshaniFintech.user_service.dto.response.ApisServicesResponseDTO;
import com.toshaniFintech.user_service.dto.response.SiteSettingResponseDTO;
import com.toshaniFintech.user_service.model.ApiSwitchingUserModel;
import com.toshaniFintech.user_service.model.ApisServiceModel;
import com.toshaniFintech.user_service.model.SiteSettingModel;
import com.toshaniFintech.user_service.service.ApisService;
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
@RequestMapping("/api/v1/api_service")
@Tag(name = "API Services", description = "APIs Services for CRUD")
public class ApisServicesController {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ApisService apisService;

    @PostMapping("/create")
    @Operation(
            summary = "Api Service",
            description = "Create a API Service List"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "API Services created successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "User already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<ApisServicesResponseDTO>> createApis(@Valid @RequestBody ApisServicesRequestDTO apisServicesRequestDto) {
        ApisServiceModel apisServiceModel = objectMapper.convertValue(apisServicesRequestDto, ApisServiceModel.class);
        ApisServiceModel updatedModel = apisService.createApisService( apisServiceModel);
        ApisServicesResponseDTO responseDTO = objectMapper.convertValue(updatedModel, ApisServicesResponseDTO.class);
        return ResponseUtil.success("API Services created successfully", responseDTO, HttpStatus.OK);
    }

    @GetMapping("/all")
    @Operation(
            summary = "Api Service",
            description = "This api is to get Api Service list"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Apis Services fetched successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "User already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    public ResponseEntity<APIResponse<List<ApisServiceModel>>> getApisServices() {
        return ResponseUtil.success("Apis Services fetched successfully", apisService.getApisService(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Api Service",
            description = "This api is to get by ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Apis service get by ID successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "User already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<ApisServiceModel>> getApiService(@PathVariable String id) {
        return ResponseUtil.success("Apis service get by ID successfully", apisService.getByID(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @Operation(
            summary = "Api Service",
            description = "This api is to update Api Service list"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Apis service updated successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "User already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<ApisServicesResponseDTO>> updateSetting(@PathVariable String id, @Valid @RequestBody ApisServicesRequestDTO apisServicesRequestDTO) {
        ApisServiceModel apisServiceModel = objectMapper.convertValue(apisServicesRequestDTO, ApisServiceModel.class);
        ApisServiceModel updatedModel = apisService.updateApisServices(id, apisServiceModel);
        ApisServicesResponseDTO responseDTO = objectMapper.convertValue(updatedModel, ApisServicesResponseDTO.class);
        return ResponseUtil.success("Apis service updated successfully", responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(
            summary = "Api Service",
            description = "This api is to delete Api Service list"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Api Service deleted successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "User already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })    public ResponseEntity<APIResponse<Object>> deleteApisService(@PathVariable String id) {
        apisService.deleteApisService(id);
        return ResponseUtil.success("Api Service deleted successfully", null, HttpStatus.OK);
    }
}
