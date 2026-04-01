package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class SettingResponse {
    private String id;
    private String settingKey;
    private String settingValue;
    private String description;
    private boolean active;
}