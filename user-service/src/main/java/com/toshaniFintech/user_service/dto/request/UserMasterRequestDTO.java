package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserMasterRequestDTO {

    private String userUuid;
    @NotBlank(message = "userName is required")
    private String username;
    @NotBlank(message = "password is required")
    private String password;
    @NotBlank(message = "emailID is required")
    private String emailId;
    @NotBlank(message = "mobile number is required")
    private String mobileNo;
    @NotBlank(message = "first name is required")
    private String firstName;
    @NotBlank(message = "middle name is required")
    private String middleName;
    @NotBlank(message = "last name is required")
    private String lastName;
    private String entityUuid;
    private String entityAdmin;
    private String role;
    private String rolePrivilegeUuid;
    private String userType;
    private String settlementType;

}