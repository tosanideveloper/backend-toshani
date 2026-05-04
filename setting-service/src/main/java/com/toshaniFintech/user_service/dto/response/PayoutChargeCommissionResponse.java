package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class PayoutChargeCommissionResponse {
    private String id;
    private Double minAmount;
    private Double maxAmount;
    private String txnType;
    private String chargeType;
    private Double charge;
}
