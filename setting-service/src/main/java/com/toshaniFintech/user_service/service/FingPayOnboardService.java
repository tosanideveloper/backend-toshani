package com.toshaniFintech.user_service.service;

import com.toshaniFintech.user_service.dto.response.FingPayOnboardResponseDTO;
import com.toshaniFintech.user_service.dto.response.SettingResponse;
import com.toshaniFintech.user_service.model.FingPayOnboardModel;

import java.util.List;

public interface FingPayOnboardService {

    List<FingPayOnboardModel> getFingPayOnboardList();
}
