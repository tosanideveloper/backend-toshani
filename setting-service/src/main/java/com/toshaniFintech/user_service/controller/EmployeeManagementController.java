package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.EmployeeManagementGetAllRequest;
import com.toshaniFintech.user_service.dto.request.EmployeeManagementRequestDTO;
import com.toshaniFintech.user_service.dto.request.MatmCommissionRequestDTO;
import com.toshaniFintech.user_service.dto.response.EmployeeManagementResponseDTO;
import com.toshaniFintech.user_service.dto.response.MatmCommissionResponseDTO;
import com.toshaniFintech.user_service.model.EmployeeManagementModel;
import com.toshaniFintech.user_service.model.MatmCommissionModel;
import com.toshaniFintech.user_service.service.EmployeeManagementService;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employee-management")

@Tag(name = "Employee Management API", description = "APIs for Employee Management")
public class EmployeeManagementController {
    @Autowired
    private EmployeeManagementService employeeManagementService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/create")
    @Operation(summary = "Create Employee Management", description = "Create Employee Management")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee Management created successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    public ResponseEntity<APIResponse<EmployeeManagementResponseDTO>> createEmployee(
            @Valid @RequestBody EmployeeManagementRequestDTO employeeManagementRequestDTO) {

        EmployeeManagementModel employeeManagementModel =
                objectMapper.convertValue(employeeManagementRequestDTO, EmployeeManagementModel.class);

        EmployeeManagementModel saved = employeeManagementService.createEmployee(employeeManagementModel);

        EmployeeManagementResponseDTO response =
                objectMapper.convertValue(saved, EmployeeManagementResponseDTO.class);

        return ResponseUtil.success("Employee Management created successfully", response, HttpStatus.OK);
    }
    @PostMapping("/all")
    @Operation(summary = "Get Employee Management",
            description = "Get Employee Management with pagination and search")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee Management fetched successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<PaginatedResponse<EmployeeManagementResponseDTO>> getAllEmployee(
            @Valid @RequestBody EmployeeManagementGetAllRequest employeeManagementGetAllRequest) {

        return new ResponseEntity<>(employeeManagementService.getAllEmployee(employeeManagementGetAllRequest), HttpStatus.OK);
    }
}
