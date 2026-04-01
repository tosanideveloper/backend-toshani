package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SettingRequest {

    @NotBlank(message = "settingKey must not be blank")
    @Size(max = 10, message = "settingKey must not exceed 10 characters")
    private String settingKey;

    @NotBlank(message = "settingValue must not be blank")
    @Size(max = 20, message = "settingValue must not exceed 20 characters")
    private String settingValue;

    @Size(min = 10, max = 500, message = "description must not exceed 500 characters")
    private String description;

}