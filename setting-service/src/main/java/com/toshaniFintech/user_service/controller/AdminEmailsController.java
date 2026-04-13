package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.AdminEmailRequestDTO;

import com.toshaniFintech.user_service.dto.response.AdminEmailResponseDTO;
import com.toshaniFintech.user_service.model.AdminEmailsModel;
import com.toshaniFintech.user_service.service.AdminEmailsService;
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
@RequestMapping("/api/v1/admin-emails")
@Tag(name = "Admin emails API", description = "APIs for Admin Emails CRUD")
public class AdminEmailsController {

    @Autowired
    private AdminEmailsService adminEmailsService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/create")
    @Operation(
            summary = "Admin Emails",
            description = "Create a API for admin emails"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Admin email created successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "User already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<AdminEmailResponseDTO>> createAdminEmail(@Valid @RequestBody AdminEmailRequestDTO adminEmailRequestDTO) {
        AdminEmailsModel adminEmailsModel = objectMapper.convertValue(adminEmailRequestDTO, AdminEmailsModel.class);
        AdminEmailsModel updatedModel = adminEmailsService.createAdminEmail(adminEmailsModel);
        AdminEmailResponseDTO responseDTO = objectMapper.convertValue(updatedModel, AdminEmailResponseDTO.class);
        return ResponseUtil.success("Admin email created successfully", responseDTO, HttpStatus.OK);
    }

    @GetMapping("/all")
    @Operation(
            summary = "Admin Emails",
            description = "fetch all admin emails"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Admin Email's fetched successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "User already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    public ResponseEntity<APIResponse<List<AdminEmailsModel>>> getAdminEmails() {
        return ResponseUtil.success("Admin Email's fetched successfully", adminEmailsService.getAdminEmails(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Admin Emails",
            description = "get Admin Email by id"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Admin Email fetched successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "User already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<AdminEmailsModel>> getAdminEmailByID(@PathVariable String id) {
        return ResponseUtil.success("Admin Email fetched successfully", adminEmailsService.getAdminEmailByID(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @Operation(
            summary = "Admin Emails",
            description = "Update Admin Email by id"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Admin Email updated successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "User already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<AdminEmailResponseDTO>> updateAdminEmail(@PathVariable String id, @Valid @RequestBody AdminEmailRequestDTO adminEmailRequestDTO) {
        AdminEmailsModel adminEmailsModel = objectMapper.convertValue(adminEmailRequestDTO, AdminEmailsModel.class);
        AdminEmailsModel updatedModel = adminEmailsService.updateAdminEmail(id, adminEmailsModel);
        AdminEmailResponseDTO responseDTO = objectMapper.convertValue(updatedModel, AdminEmailResponseDTO.class);
        return ResponseUtil.success("Admin Email updated successfully", responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(
            summary = "Admin Emails",
            description = "Delete Admin Email"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Admin Email deleted successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "User already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })    public ResponseEntity<APIResponse<Object>> deleteAdminEmail(@PathVariable String id) {
        adminEmailsService.deleteAdminEmail(id);
        return ResponseUtil.success("Admin Email deleted successfully", null, HttpStatus.OK);
    }


}
