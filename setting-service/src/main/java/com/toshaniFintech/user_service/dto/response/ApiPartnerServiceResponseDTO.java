package com.toshaniFintech.user_service.dto.response;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ApiPartnerServiceResponseDTO {
    private String id;
    private String partnerDetails;
    private String date;
    private String serviceName;
    private String status;
    private String remarks;
}
