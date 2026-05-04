package com.toshaniFintech.user_service.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Aeps1CommissionGetAll {
    private List<String> commType;

    @NotNull(message = "startDate is required")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @NotNull(message = "endDate is required")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    @Min(value = 0, message = "pageNo must be >= 0")
    private int pageNo;
    @Min(value = 1, message = "pageSize must be > 0")
    private int pageSize;
    private String sortBy ;
    private String orderBy ;
    private String search;
    private String searchByField;
}
