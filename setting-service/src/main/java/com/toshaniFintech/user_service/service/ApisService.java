package com.toshaniFintech.user_service.service;

import com.toshaniFintech.user_service.dto.request.ApisServicesRequestDTO;
import com.toshaniFintech.user_service.dto.response.ApisServicesResponseDTO;
import com.toshaniFintech.user_service.model.ApisServiceModel;
import com.toshaniFintech.user_service.model.SiteSettingModel;

import java.util.List;

public interface ApisService {
    List<ApisServiceModel> getApisService();

    ApisServiceModel createApisService(ApisServiceModel apisServiceModel);

    ApisServiceModel updateApisServices(String id, ApisServiceModel apisServiceModel);

    void deleteApisService(String id);



}
