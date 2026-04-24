package com.toshaniFintech.user_service.dto.request;

import lombok.Data;

@Data
public class ExpressUpiChargeRequestDTO {

    private Double minAmount;
    private Double maxAmount;
    private String chargeType;

    // pagination
    private int pageNo;
    private int pageSize;
    private String sortBy;
    private String orderBy;

    // search
    private String search;
    private String searchByField;
}