package com.toshaniFintech.user_service.service;

import com.toshaniFintech.user_service.model.ApiPartnerServiceModel;

import java.util.List;

public interface ApiPartnerService {
    List<ApiPartnerServiceModel> getAllApiPartnerServices();
    ApiPartnerServiceModel createApisPartnerService(ApiPartnerServiceModel apiPartnerServiceModel);
    void deleteApiPartnerService(String id);
}
