package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.user_service.entity.Aeps2ReportEntity;
import com.toshaniFintech.user_service.model.Aeps2ReportModel;
import com.toshaniFintech.user_service.repository.Aeps2ReportRepository;
import com.toshaniFintech.user_service.service.Aeps2ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Aeps2ReportServiceImpl implements Aeps2ReportService {

    @Autowired
    private Aeps2ReportRepository aeps2ReportRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Aeps2ReportModel getAeps2Report(Aeps2ReportModel aeps2ReportModel) {
        Aeps2ReportEntity aeps2ReportEntity = objectMapper.convertValue(aeps2ReportModel, Aeps2ReportEntity.class);
        Aeps2ReportEntity saved = aeps2ReportRepository.save(aeps2ReportEntity);
        return objectMapper.convertValue(saved, Aeps2ReportModel.class);
    }
}