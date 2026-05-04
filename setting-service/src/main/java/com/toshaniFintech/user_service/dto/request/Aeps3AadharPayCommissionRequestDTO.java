package com.toshaniFintech.user_service.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Aeps3AadharPayCommissionRequestDTO {
    @NotNull(message = "minAmount is required")
    private Double minAmount;

    @NotNull(message = "maxAmount is required")
    private Double maxAmount;

    @NotBlank(message = "chargeType is required")
    private String chargeType;

    @NotNull(message = "charge is required")
    private Double charge;

    @NotBlank(message = "rrn is required")
    private String rrn;

    @NotNull(message = "createDate is required")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createDate;
}
