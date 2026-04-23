package com.toshaniFintech.user_service.dto.request;

import lombok.Data;

@Data
public class CardPayChargeRequestDTO {

    private Double minAmount;
    private Double maxAmount;
    private String chargeType;

    private int pageNo;
    private int pageSize;
    private String sortBy;
    private String orderBy;

    private String search;
    private String searchByField;
}