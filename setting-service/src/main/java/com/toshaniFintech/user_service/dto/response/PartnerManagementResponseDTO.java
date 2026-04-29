package com.toshaniFintech.user_service.dto.response;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PartnerManagementResponseDTO {
    private String id;
    private String name;
    private String mobileNumber;
    private String uploadPancard;
    private String address;
    private String state;
    private String pinCode;
    private String companyName;
    private String email;
    private String uploadAadharCard;
    private String city;
    private String country;
    private String agentID;
}
