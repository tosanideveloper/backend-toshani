package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class PaytmPosChargeResponseDTO {

    private String id;
    private Double minAmount;
    private Double maxAmount;
    private String paymentMode;
    private String chargeType;
    private Double charge;
}