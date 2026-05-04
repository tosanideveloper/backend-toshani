package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MatmCommissionResponseDTO {

    private String id;
    private Double minAmount;
    private Double maxAmount;
    private String commType;
    private Double comm;
    private LocalDate createDate;
}
