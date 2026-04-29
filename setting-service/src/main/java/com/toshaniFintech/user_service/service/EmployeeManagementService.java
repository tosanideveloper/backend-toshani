package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.EmployeeManagementGetAllRequest;
import com.toshaniFintech.user_service.dto.response.EmployeeManagementResponseDTO;
import com.toshaniFintech.user_service.model.EmployeeManagementModel;

public interface EmployeeManagementService {
    EmployeeManagementModel createEmployee(EmployeeManagementModel employeeManagementModel);

    PaginatedResponse<EmployeeManagementResponseDTO> getAllEmployee(
            EmployeeManagementGetAllRequest employeeManagementGetAllRequest);
}
