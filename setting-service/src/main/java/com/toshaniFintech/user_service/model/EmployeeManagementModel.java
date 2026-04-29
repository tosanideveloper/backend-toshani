package com.toshaniFintech.user_service.model;

import lombok.Data;

@Data
public class EmployeeManagementModel {
    private String id;
    private String employeeCode;
    private String name;
    private String email;
    private String mobile;
    private String status;
}
