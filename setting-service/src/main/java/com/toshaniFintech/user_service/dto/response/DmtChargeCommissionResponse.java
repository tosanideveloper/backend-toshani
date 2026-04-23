package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DmtChargeCommissionResponse {
    private String id;
    private String slNo;
    private BigDecimal minAmount;
    private BigDecimal maxAmount;
    private String commType;
    private BigDecimal comm;
    private boolean active;
}

