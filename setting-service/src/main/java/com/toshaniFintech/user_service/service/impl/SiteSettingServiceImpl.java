package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.user_service.entity.SiteSettingEntity;
import com.toshaniFintech.user_service.model.SiteSettingModel;
import com.toshaniFintech.user_service.repository.SiteSettingRepository;
import com.toshaniFintech.user_service.service.SiteSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteSettingServiceImpl implements SiteSettingService {

    @Autowired
    SiteSettingRepository siteSettingRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public List<SiteSettingModel> getAllSiteSettings() {
        List<SiteSettingEntity> settings = siteSettingRepository.findAll();
        List<SiteSettingModel> siteSettingList = settings.stream()
                .map(siteSettingEntity -> objectMapper.convertValue(siteSettingEntity, SiteSettingModel.class)).toList();

        return siteSettingList;

    }

    @Override
    public SiteSettingModel updateSiteSetting(String id, SiteSettingModel siteSettingModel) {
        SiteSettingEntity entity = siteSettingRepository.findById(id).orElseThrow(() -> new RuntimeException("Setting not found with id: " + id));
        entity.setAddress(siteSettingModel.getAddress());
        entity.setCity(siteSettingModel.getCity());
        entity.setPinCode(siteSettingModel.getPinCode());
        entity.setPhone(siteSettingModel.getPhone());
        entity.setEmail(siteSettingModel.getEmail());
        entity.setState(siteSettingModel.getState());
        entity.setCountry(siteSettingModel.getCountry());

        SiteSettingEntity saved = siteSettingRepository.save(entity);

        return objectMapper.convertValue(saved, SiteSettingModel.class);
    }
}
