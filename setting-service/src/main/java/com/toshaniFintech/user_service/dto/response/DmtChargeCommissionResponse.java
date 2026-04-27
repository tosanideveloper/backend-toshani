package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DmtChargeCommissionResponse {
    private String id;
    private String slNo;
    private Double minAmount;
    private Double maxAmount;
    private String commType;
    private Double comm;
    private boolean active;
}

