package com.toshaniFintech.user_service.model;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ApiPartnerServiceModel {
    private String partnerDetails;
    private String date;
    private String serviceName;
    private String status;
    private String remarks;
}
