package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpiExpressAccountRequestDTO {

    private String accountNo;
    private Double limitAmount;
    private String txnDate;

    // pagination
    private int pageNo;
    private int pageSize;
    private String sortBy;
    private String orderBy;

    // search
    private String search;
    private String searchByField;
}