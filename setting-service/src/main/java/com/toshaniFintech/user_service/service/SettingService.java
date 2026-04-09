package com.toshaniFintech.user_service.service;


import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.SettingRequest;
import com.toshaniFintech.user_service.dto.response.SettingResponse;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface SettingService {

    SettingResponse createSetting(SettingRequest settingRequest);

    PaginatedResponse<SettingResponse> getAllSettings(PageRequest pageRequest);

    SettingResponse getSettingById(String id);

    SettingResponse updateSetting(String id, SettingRequest settingModel);

    void deleteSetting(String id);
}