package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class UserBasicInfoResponse {

    private String id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String username;
    private String email;
    private String mobile;
    private boolean mobileVerified;
    private boolean emailVerified;
    private boolean active;
    private List<String> roles;
    private String entityUuid;
    private Boolean entityAdmin;
    private String userType;
}
