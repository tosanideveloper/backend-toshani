package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Aeps3AadharPayCommissionResponseDTO {
    private String id;
    private Double minAmount;
    private Double maxAmount;
    private String chargeType;
    private Double charge;
    private String rrn;
    private LocalDate createDate;
}
