package com.toshaniFintech.user_service.service;


import com.toshaniFintech.user_service.dto.request.SettingRequest;
import com.toshaniFintech.user_service.dto.response.SettingResponse;

import java.util.List;

public interface SettingService {

    SettingResponse createSetting(SettingRequest settingRequest);

    List<SettingResponse> getAllSettings();

    SettingResponse getSettingById(String id);

    SettingResponse updateSetting(String id, SettingRequest settingModel);

    void deleteSetting(String id);
}