package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.EmployeeManagementGetAll;
import com.toshaniFintech.user_service.dto.request.EmployeeManagementRequestDTO;
import com.toshaniFintech.user_service.dto.response.EmployeeManagementResponseDTO;
import com.toshaniFintech.user_service.model.EmployeeManagementModel;
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
import org.springframework.web.bind.annotation.*;

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
            @Valid @RequestBody EmployeeManagementGetAll employeeManagementGetAll) {

        return new ResponseEntity<>(employeeManagementService.getAllEmployee(employeeManagementGetAll), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    @Operation(summary = "Get Employee Management by ID", description = "Fetch single Employee Management by ID")
    @ApiResponses(value = {@ApiResponse(responseCode = "200",
            description = "Employee Management fetched successfully"),
            @ApiResponse(responseCode = "404", description = "Employee Management not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<APIResponse<EmployeeManagementResponseDTO>> getByIdEmployee(
            @PathVariable String id) {

        EmployeeManagementResponseDTO employeeManagementResponseDTO =
                employeeManagementService.getByIdEmployee(id);

        return ResponseUtil.success("Employee Management fetched successfully",
                employeeManagementResponseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update Employee Management", description = "Update Employee Management")
    @ApiResponses(value = {@ApiResponse(responseCode = "200",
            description = "Employee Management updated successfully", content = @Content(
            schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Employee Management not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})

    public ResponseEntity<APIResponse<EmployeeManagementResponseDTO>> updateEmployee(
            @PathVariable String id,
            @Valid @RequestBody EmployeeManagementRequestDTO employeeManagementRequestDTO) {

        EmployeeManagementModel employeeManagementModel = objectMapper.convertValue(
                employeeManagementRequestDTO, EmployeeManagementModel.class);

        EmployeeManagementResponseDTO employeeManagementResponseDTO = employeeManagementService.
                updateEmployee(id, employeeManagementModel);

        return ResponseUtil.success("Employee Management updated successfully",
                employeeManagementResponseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete Employee Management", description = "Delete Employee Management by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee Management deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Employee Management not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<APIResponse<String>> deleteAeps3(
            @PathVariable String id) {

        employeeManagementService.deleteEmployee(id);

        return ResponseUtil.success("Employee Management deleted successfully",
                "Deleted", HttpStatus.OK);
    }
}
