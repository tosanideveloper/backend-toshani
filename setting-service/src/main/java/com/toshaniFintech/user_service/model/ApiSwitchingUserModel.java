package com.toshaniFintech.user_service.model;

import lombok.Data;

@Data
public class ApiSwitchingUserModel {
    private String id;
    private String switchCategoryCode;
    private String switchCategoryName;
    private String switchIP;
}
