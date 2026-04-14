package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.AffiliateUserRequestDTO;
import com.toshaniFintech.user_service.dto.response.AffiliateUserResponseDTO;
import com.toshaniFintech.user_service.model.AffiliateUserModel;
import com.toshaniFintech.user_service.service.AffiliateUserService;
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
@RequestMapping("/api/v1/afiliate-user")
@Tag(name = "Affiliate user API", description = "APIs for add affiliate user")
public class AffiliateUserController {
    @Autowired
    private AffiliateUserService affiliateUserService;

    @Autowired
    private ObjectMapper objectMapper;


    @GetMapping("/all")
    @Operation(summary = "Add Affiliate user", description = "get a Affiliate user")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Affiliate user fetched successfully", content = @Content(schema = @Schema(implementation = APIResponse.class))), @ApiResponse(responseCode = "400", description = "Invalid input data"), @ApiResponse(responseCode = "409", description = "User already exists"), @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<APIResponse<List<AffiliateUserModel>>> getAffiliateUser() {
        return ResponseUtil.success("Affiliate user fetched successfully", affiliateUserService.getAffiliateUSer(), HttpStatus.OK);
    }

    @PostMapping("/create")
    @Operation(summary = "Add Affiliate user", description = "This api is to Create Add Affiliate user")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Add Affiliate user created successfully", content = @Content(schema = @Schema(implementation = APIResponse.class))), @ApiResponse(responseCode = "400", description = "Invalid input data"), @ApiResponse(responseCode = "409", description = "Data does not exists"), @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<APIResponse<AffiliateUserResponseDTO>> createAffiliateUser(@Valid @RequestBody AffiliateUserRequestDTO affiliateUserRequestDTO) {
        AffiliateUserModel affiliateUserModel = objectMapper.convertValue(affiliateUserRequestDTO, AffiliateUserModel.class);
        AffiliateUserModel addAffiliateUserModel = affiliateUserService.createAffiliateUser(affiliateUserModel);
        AffiliateUserResponseDTO responseDTO = objectMapper.convertValue(addAffiliateUserModel, AffiliateUserResponseDTO.class);
        return ResponseUtil.success("Add Affiliate user created successfully", responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Add Affiliate user", description = "This api is to Delete API for Affiliate user")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Add Affiliate user Services deleted successfully", content = @Content(schema = @Schema(implementation = APIResponse.class))), @ApiResponse(responseCode = "400", description = "Invalid input data"), @ApiResponse(responseCode = "409", description = "Data does not exists"), @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<APIResponse<Object>> deletePartner(@PathVariable String id) {
        affiliateUserService.deleteUser(id);
        return ResponseUtil.success("API Partner ServicesAdd Affiliate user deleted successfully", null, HttpStatus.OK);
    }
}
