package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.user_service.dto.request.SiteSettingRequestDTO;
import com.toshaniFintech.user_service.dto.response.APIResponse;
import com.toshaniFintech.user_service.dto.response.SiteSettingResponseDTO;
import com.toshaniFintech.user_service.model.ApisServiceModel;
import com.toshaniFintech.user_service.model.SiteSettingModel;
import com.toshaniFintech.user_service.service.SiteSettingService;
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
@RequestMapping("/api/v1/site-setting")
@Tag(name = "Site Setting API", description = "APIs for Site Settings CRUD")
public class SiteSettingController {

    @Autowired
    private SiteSettingService siteSettingService;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/all")
    @Operation(
            summary = "Site Setting Service",
            description = "get a Site Setting Service"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Site Settings fetched successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "User already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<List<SiteSettingModel>>> getAllSiteSetting() {
        return ResponseUtil.success("Site Settings fetched successfully", siteSettingService.getAllSiteSettings(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Site Setting Service",
            description = "This api is to get by ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Apis service get by ID successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "User already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<SiteSettingModel>> getSiteSettingWithID(@PathVariable String id) {
        return ResponseUtil.success("Site Settings fetched successfully", siteSettingService.getSiteSettingByID(id), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    @Operation(
            summary = "Site Setting Service",
            description = "Update a Site Setting Service"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Site Setting updated successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "User already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<SiteSettingResponseDTO>> updateSiteSetting(@PathVariable String id, @Valid @RequestBody SiteSettingRequestDTO siteSettingRequestDTO) {
        SiteSettingModel siteSettingModel = objectMapper.convertValue(siteSettingRequestDTO, SiteSettingModel.class);
        SiteSettingModel updatedModel = siteSettingService.updateSiteSetting(id, siteSettingModel);
        SiteSettingResponseDTO responseDTO = objectMapper.convertValue(updatedModel, SiteSettingResponseDTO.class);
        return ResponseUtil.success("Site Setting updated successfully", responseDTO, HttpStatus.OK);
    }

}
