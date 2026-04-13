package com.toshaniFintech.user_service.service;

import com.toshaniFintech.user_service.model.ApiSwitchingUserModel;

import java.util.List;

public interface SwitchingUserService {
    List<ApiSwitchingUserModel> getApiSwitchingUser();

    ApiSwitchingUserModel getSwitchUserByID(String id);

    ApiSwitchingUserModel updateSwitchUser(String id, ApiSwitchingUserModel apiSwitchingUserModel);

}
