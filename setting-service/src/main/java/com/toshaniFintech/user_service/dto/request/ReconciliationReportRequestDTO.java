package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;

@Data
public class ReconciliationReportRequestDTO {
    @NotBlank(message = "start date must not be blank")
    private Date startDate;
    @NotBlank(message = "end date must not be blank")
    private Date endDate;
}
