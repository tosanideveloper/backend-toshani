package com.toshaniFintech.user_service.dto.request;

import lombok.Data;

@Data
public class ApiSwitchingUserRequestDTO {
    private String switchCategoryCode;
    private String switchCategoryName;
    private String switchIP;
}
