package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class UserMasterResponse {

    private String userUuid;
    private String id;
    private String username;
    private String emailId;
    private String mobileNo;

    private String firstName;
    private String middleName;
    private String lastName;

    private String entityUuid;

    private String role;
    private String userType;
    private String settlementType;
}