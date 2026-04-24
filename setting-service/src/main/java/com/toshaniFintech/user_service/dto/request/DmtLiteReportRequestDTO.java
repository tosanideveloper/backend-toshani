package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class DmtLiteReportRequestDTO {

    // Advanced Filters
    private List<String> transactionId;
    private List<String> orderId;
    private List<String> accountNumber;
    private List<String> ifsc;
    private List<String> utr;
    private List<String> type;
    private List<String> status;
    private List<String> apiName;

    // Date Range
    @NotBlank(message = "startDate is required")
    private String startDate;

    @NotBlank(message = "endDate is required")
    private String endDate;

    // Pagination
    private int pageNo;
    private int pageSize;

    // Sorting
    private String sortBy;
    private String orderBy;

    // Search
    private String search;
    private String searchByField;
}