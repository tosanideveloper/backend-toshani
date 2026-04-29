package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class Aeps2CommissionResponseDTO {
    private String id;
    private Double minAmount;
    private Double maxAmount;
    private String commType;
    private Double commission;
    private String transactionType;
    private String rrn;
}
