package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ActivityReportRequest {
    @NotBlank(message = "apiUserDetail must not be blank")
    @Size(max = 150, message = "apiUserDetail must not exceed 150 characters")
    private String apiUserDetail;

    @NotBlank(message = "updatedBy must not be blank")
    @Size(max = 100, message = "updatedBy must not exceed 100 characters")
    private String updatedBy;

    @NotBlank(message = "functionName must not be blank")
    @Size(max = 150, message = "functionName must not exceed 150 characters")
    private String functionName;

    @NotBlank(message = "fromDate must not be blank")
    @Size(max = 30, message = "fromDate must not exceed 30 characters")
    private String fromDate;

    @NotBlank(message = "toDate must not be blank")
    @Size(max = 30, message = "toDate must not exceed 30 characters")
    private String toDate;
}
