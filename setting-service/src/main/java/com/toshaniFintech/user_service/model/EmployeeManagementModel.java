package com.toshaniFintech.user_service.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeManagementModel {
    private String id;
    private String employeeCode;
    private String name;
    private String email;
    private String mobile;
    private String status;
    private LocalDate createDate;
}
