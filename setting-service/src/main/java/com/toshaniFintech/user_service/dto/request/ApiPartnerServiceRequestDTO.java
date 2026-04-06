package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ApiPartnerServiceRequestDTO {
    @NotBlank(message = "Partner details must not be blank")
    private String partnerDetails;
    @NotBlank(message = "Date must not be blank")
    private String date;
    @NotBlank(message = "Service name must not be blank")
    private String serviceName;
    @NotBlank(message = "Status must not be blank")
    private String status;
    @NotBlank(message = "Remarks must not be blank")
    private String remarks;
}
