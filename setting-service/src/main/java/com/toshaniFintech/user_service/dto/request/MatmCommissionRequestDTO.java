package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class MatmCommissionRequestDTO {

    private List<String> commtype;
    private List<String> comm;
    @NotBlank(message = "startDate is required")
    private String startDate;

    @NotBlank(message = "endDate is required")
    private String endDate;
    private Double minAmount;
    private Double maxAmount;

    private int pageNo;
    private int pageSize;
    private String sortBy;
    private String orderBy;

    private String search;
    private String searchByField;
}
