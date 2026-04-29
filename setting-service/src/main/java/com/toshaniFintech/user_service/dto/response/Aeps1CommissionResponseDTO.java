package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class Aeps1CommissionResponseDTO {

    private String id;
    private Double minAmount;
    private Double maxAmount;
    private String commType;
    private Double commission;
    private String rrn;

}
