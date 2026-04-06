package com.toshaniFintech.user_service.service;

import com.toshaniFintech.user_service.model.ApiSwitchingUserModel;
import com.toshaniFintech.user_service.model.SiteSettingModel;

import java.util.List;

public interface ApiSwitchingUserService {
    List<ApiSwitchingUserModel> getApiSwitchingUser();

    ApiSwitchingUserModel getSwitchUserByID(String id);

    ApiSwitchingUserModel updateSwitchUser(String id, ApiSwitchingUserModel apiSwitchingUserModel);

}
