package com.toshaniFintech.user_service.service;

import com.toshaniFintech.user_service.model.ApiAllMerchantModel;
import com.toshaniFintech.user_service.model.ApisServiceModel;
import com.toshaniFintech.user_service.model.SiteSettingModel;

import java.util.List;

public interface ApiAllMerchantService {
    List<ApiAllMerchantModel> getAllApiMerchantService();
    ApiAllMerchantModel getByID(String id);
    ApiAllMerchantModel updateAllMerchant(String id, ApiAllMerchantModel apiAllMerchantModel);
}
