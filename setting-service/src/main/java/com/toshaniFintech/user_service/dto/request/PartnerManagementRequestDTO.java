package com.toshaniFintech.user_service.dto.request;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PartnerManagementRequestDTO {
    @NotBlank(message = "name must not be blank")
    private String name;
    @NotBlank(message = "mobile number name must not be blank")
    private String mobileNumber;
    @NotBlank(message = "pan card must not be blank")
    private String uploadPancard;
    @NotBlank(message = "address must not be blank")
    private String address;
    @NotBlank(message = "state must not be blank")
    private String state;
    @NotBlank(message = "pincode must not be blank")
    private String pinCode;
    @NotBlank(message = "company name must not be blank")
    private String companyName;
    @NotBlank(message = "email must not be blank")
    private String email;
    @NotBlank(message = "Aadhar Card must not be blank")
    private String uploadAadharCard;
    @NotBlank(message = "city must not be blank")
    private String city;
    @NotBlank(message = "country must not be blank")
    private String country;
    @NotBlank(message = "agentID must not be blank")
    private String agentID;
}
