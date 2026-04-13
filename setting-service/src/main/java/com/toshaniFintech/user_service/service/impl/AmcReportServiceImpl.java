package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.user_service.entity.AmcReportEntity;
import com.toshaniFintech.user_service.model.AmcReportModel;
import com.toshaniFintech.user_service.repository.AmcReportRepository;
import com.toshaniFintech.user_service.service.AmcReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmcReportServiceImpl implements AmcReportService {

    @Autowired
    private AmcReportRepository amcReportRepository;

    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public List<AmcReportModel> getAllAmcReport() {
        List<AmcReportEntity> amcReportEntityList = amcReportRepository.findAll();
        return amcReportEntityList.stream().map
                (amcReportEntity -> objectMapper.convertValue(amcReportEntity,
                        AmcReportModel.class)).toList();
    }

}
