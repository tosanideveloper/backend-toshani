package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserMasterFetchRequestDTO {

    private String role;
    private String userType;
    private String settlementType;
    private String username;
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
