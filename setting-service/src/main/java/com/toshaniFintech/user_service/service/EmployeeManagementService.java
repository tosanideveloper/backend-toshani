package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.EmployeeManagementGetAllRequest;
import com.toshaniFintech.user_service.dto.response.EmployeeManagementResponseDTO;
import com.toshaniFintech.user_service.dto.response.MatmCommissionResponseDTO;
import com.toshaniFintech.user_service.model.EmployeeManagementModel;
import com.toshaniFintech.user_service.model.MatmCommissionModel;

public interface EmployeeManagementService {
    EmployeeManagementModel createEmployee(EmployeeManagementModel employeeManagementModel);

    PaginatedResponse<EmployeeManagementResponseDTO> getAllEmployee(
            EmployeeManagementGetAllRequest employeeManagementGetAllRequest);

    EmployeeManagementResponseDTO getByIdEmployee(String id);

    EmployeeManagementResponseDTO updateEmployee(String id, EmployeeManagementModel employeeManagementModel);

    void deleteEmployee(String id);
}
