package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class EmployeeManagementResponseDTO {
    private String id;
    private String employeeCode;
    private String name;
    private String email;
    private String mobile;
    private String status;
}
