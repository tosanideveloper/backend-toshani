package com.toshaniFintech.user_service.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class MatmCommissionRequestDTO {

    // Filters
    private List<String> commtype;
    private List<String> comm;

    private Double minAmount;
    private Double maxAmount;

    // Pagination
    private int pageNo;
    private int pageSize;
    private String sortBy;
    private String orderBy;

    // Search
    private String search;
    private String searchByField;
}
