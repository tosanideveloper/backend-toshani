package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ApisServicesRequestDTO {

    @NotBlank(message = "serviceName must not be blank")
    @Size(max = 100, message = "serviceName must not exceed 100 characters")
    private String serviceName;

    @NotBlank(message = "apiName must not be blank")
    @Size(max = 100, message = "apiName must not exceed 100 characters")
    private String apiName;

    @NotBlank(message = "status must not be blank")
    private String status;

    @Size(max = 255, message = "remark must not exceed 255 characters")
    private String remark;

    @NotBlank(message = "date must not be blank")
    @Pattern(
            regexp = "^\\d{4}-\\d{2}-\\d{2}$",
            message = "date must be in format yyyy-MM-dd"
    )
    private String date;

    @NotBlank(message = "partnerDetails must not be blank")
    @Size(max = 150, message = "partnerDetails must not exceed 150 characters")
    private String partnerDetails;
}