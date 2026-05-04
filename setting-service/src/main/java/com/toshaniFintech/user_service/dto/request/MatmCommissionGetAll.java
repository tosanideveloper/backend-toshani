package com.toshaniFintech.user_service.dto.request;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class MatmCommissionGetAll {

    // Optional filter
    private List<
            @NotBlank(message = "commType value must not be blank")
                    String> commType;

    // Mandatory
    @NotNull(message = "startDate is required")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @NotNull(message = "endDate is required")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    // Date validation
    @AssertTrue(message = "startDate must be before or equal to endDate")
    public boolean isValidDateRange() {
        if (startDate == null || endDate == null) return true;
        return !startDate.isAfter(endDate);
    }

    // Pagination
    @Min(value = 0, message = "pageNo must be >= 0")
    private int pageNo = 0;

    @Min(value = 1, message = "pageSize must be > 0")
    @Max(value = 100, message = "pageSize must not exceed 100")
    private int pageSize = 10;

    // Sorting (optional but validated if provided)
    @Pattern(
            regexp = "^(commType|comm|minAmount|maxAmount|rrn|createDate)$",
            message = "sortBy must be one of: commType, comm, minAmount, maxAmount, rrn, createDate"
    )
    private String sortBy = "commType";

    @Pattern(
            regexp = "^(ASC|DESC)$",
            message = "orderBy must be ASC or DESC"
    )
    private String orderBy = "DESC";

    // Search (optional)
    private String search;

    @Pattern(
            regexp = "^(commType|rrn)?$",
            message = "searchByField must be either commType or rrn"
    )
    private String searchByField;
}