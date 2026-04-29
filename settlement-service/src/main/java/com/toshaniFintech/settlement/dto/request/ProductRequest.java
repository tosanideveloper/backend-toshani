package com.toshaniFintech.settlement.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductRequest {

    @NotBlank(message = "Product name is mandatory")
    private String productName;

    private String productDescription;

    @NotNull(message = "Settlement day is mandatory")
    @Min(value = 0, message = "Settlement day must be 0 or more")
    private Integer settlementDay;
}