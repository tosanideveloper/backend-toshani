package com.toshaniFintech.user_service.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Aeps2AadharPayCommissionRequestDTO {

    @NotNull(message = "minAmount is required")
    private Double minAmount;

    @NotNull(message = "maxAmount is required")
    private Double maxAmount;

    @NotBlank(message = "commType is required")
    private String commType;

    @NotNull(message = "comm is required")
    private Double comm;

    @NotBlank(message = "rrn is required")
    private String rrn;

    @NotNull(message = "createDate is required")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createDate;
}