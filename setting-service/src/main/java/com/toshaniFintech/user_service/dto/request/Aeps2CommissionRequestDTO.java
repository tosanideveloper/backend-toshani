package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class Aeps2CommissionRequestDTO {

    private List<String> commType;
    private List<String> commission;
    private String transactionType;
    @NotBlank(message = "startDate is required")
    private String startDate;

    @NotBlank(message = "endDate is required")
    private String endDate;
    private int pageNo;
    private int pageSize;
    private String sortBy;
    private String orderBy;

    private String search;
    private String searchByField;
}
