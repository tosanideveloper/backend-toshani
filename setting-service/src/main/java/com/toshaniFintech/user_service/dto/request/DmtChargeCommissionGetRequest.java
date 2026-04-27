package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DmtChargeCommissionGetRequest {
    @NotNull(message = "pageNo is required")
    private int pageNo;

    @NotNull(message = "pageSize is required")
    private int pageSize;

    private String sortBy;
    private String orderBy;

    private String search;
    private String searchByField;
}
