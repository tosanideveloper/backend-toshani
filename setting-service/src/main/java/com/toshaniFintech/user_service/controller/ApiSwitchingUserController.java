package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.user_service.dto.request.ApiSwitchingUserRequestDTO;
import com.toshaniFintech.user_service.dto.response.APIResponse;
import com.toshaniFintech.user_service.dto.response.ApiSwitchingUserResponseDTO;
import com.toshaniFintech.user_service.model.ApiSwitchingUserModel;
import com.toshaniFintech.user_service.service.SwitchingUserService;
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
@RequestMapping("/api/v1/api-switch")
@Tag(name = "API Switching User", description = "APIs for Switching User CRUD")
public class ApiSwitchingUserController {

    @Autowired
    private SwitchingUserService switchingUserService;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/all")
    @Operation(
            summary = "Api Switching User",
            description = "get a API for Switching User"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Api Switching User fetched successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "User already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<List<ApiSwitchingUserModel>>> getApiSwitchingUser() {
        return ResponseUtil.success("Api Switching User fetched successfully", switchingUserService.getApiSwitchingUser(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Api Switching User",
            description = "get a API for Switching User with ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "API Switching User fetched successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "User already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<ApiSwitchingUserModel>> getSwitchUser(@PathVariable String id) {
        return ResponseUtil.success("API Switching User fetched successfully", switchingUserService.getSwitchUserByID(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @Operation(
            summary = "Api Switching User",
            description = "get a API for Switching User with ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Switch User updated successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "User already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<ApiSwitchingUserResponseDTO>> updateSwitchUser(@PathVariable String id, @Valid @RequestBody ApiSwitchingUserRequestDTO apiSwitchingUserRequestDTO) {
        ApiSwitchingUserModel apiSwitchingUserModel = objectMapper.convertValue(apiSwitchingUserRequestDTO, ApiSwitchingUserModel.class);
        ApiSwitchingUserModel updatedModel = switchingUserService.updateSwitchUser(id, apiSwitchingUserModel);
        ApiSwitchingUserResponseDTO responseDTO = objectMapper.convertValue(updatedModel, ApiSwitchingUserResponseDTO.class);
        return ResponseUtil.success("Switch User updated successfully", responseDTO, HttpStatus.OK);
    }
}
