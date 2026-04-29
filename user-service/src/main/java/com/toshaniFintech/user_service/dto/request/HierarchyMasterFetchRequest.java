package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class HierarchyMasterFetchRequest {
    private String hirarchyName;
    private String parentHierarchy;
    private String hirarchyStatus;
    private int pageNo;
    private int pageSize;
    @NotBlank(message = "startDate is required")
    private String startDate;
    @NotBlank(message = "endDate is required")
    private String endDate;
    private String sortBy;
    private String orderBy;
    private String search;
    private String searchByField;
}
