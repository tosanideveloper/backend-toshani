package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;
@Data
public class HdfcVirtualLogRequest {
    private List<String> userId;
    private List<String> status;
    private List<String> userName;
    private List<String> accountNumber;

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
