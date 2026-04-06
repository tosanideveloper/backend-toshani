package com.toshaniFintech.user_service.service;

import com.toshaniFintech.user_service.model.ApisServiceModel;
import com.toshaniFintech.user_service.model.SiteSettingModel;

import java.util.List;

public interface SiteSettingService {
    List<SiteSettingModel> getAllSiteSettings();

    SiteSettingModel updateSiteSetting(String id, SiteSettingModel siteSettingModel);
    SiteSettingModel getSiteSettingByID(String id);


}
