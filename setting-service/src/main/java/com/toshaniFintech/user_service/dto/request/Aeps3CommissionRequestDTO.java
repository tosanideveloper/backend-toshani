package com.toshaniFintech.user_service.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Aeps3CommissionRequestDTO {
    @NotNull(message = "minAmount is required")
    private Double minAmount;

    @NotNull(message = "maxAmount is required")
    private Double maxAmount;

    @NotBlank(message = "transactionType is required")
    private String transactionType;

    @NotBlank(message = "commissionType is required")
    private String commissionType;

    @NotNull(message = "commission is required")
    private Double commission;

    @NotBlank(message = "rrn is required")
    private String rrn;

    @NotNull(message = "createDate is required")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createDate;
}
