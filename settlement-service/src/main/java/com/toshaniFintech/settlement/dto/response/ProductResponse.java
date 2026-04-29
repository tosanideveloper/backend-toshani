package com.toshaniFintech.settlement.dto.response;

import lombok.Data;

@Data
public class ProductResponse {

    private String id;
    private String productUuid;
    private String productName;
    private String productDescription;
    private Integer settlementDay;
    private boolean active;
}