package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class UpiLiteChargeResponseDTO {

    private String id;
    private Double minAmount;
    private Double maxAmount;
    private String chargeType;
    private Double charge;
}