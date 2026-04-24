package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class VerificationReportRequestDTO {

    @NotBlank(message = "start date must not be blank")
    private String startDate;

    @NotBlank(message = "end date must not be blank")
    private String endDate;
}