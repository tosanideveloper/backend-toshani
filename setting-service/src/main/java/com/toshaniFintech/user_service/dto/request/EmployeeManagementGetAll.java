package com.toshaniFintech.user_service.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class EmployeeManagementGetAll {

    private List<String> status;

    @NotNull(message = "startDate is required")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @NotNull(message = "endDate is required")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @AssertTrue(message = "startDate must be before or equal to endDate")
    public boolean isValidDateRange() {
        if (startDate == null || endDate == null) return true;
        return !startDate.isAfter(endDate);
    }

    @Min(value = 0, message = "pageNo must be 0 or greater")
    private int pageNo;
    @Min(value = 1, message = "pageSize must be greater than 0")
    private int pageSize;

    @Pattern(
            regexp = "employeeCode|name|email|mobile|status|createdDate",
            message = "Invalid sortBy field"
    )
    private String sortBy = "name";

    @Pattern(
            regexp = "ASC|DESC|asc|desc",
            message = "orderBy must be ASC or DESC"
    )
    private String orderBy = "DESC";

    private String search;

    @Pattern(
            regexp = "employeeCode|name|email|mobile|status",
            message = "Invalid searchByField"
    )
    private String searchByField;
}