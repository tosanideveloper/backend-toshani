package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EntityMasterFetchRequest {
    private String parentHierarchy;
    private String hirarchyLevel;
    private String entityName;
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
