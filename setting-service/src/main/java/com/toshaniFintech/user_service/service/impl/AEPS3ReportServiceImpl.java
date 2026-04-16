package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.user_service.dto.response.AEPS3ReportResponse;
import com.toshaniFintech.user_service.entity.AEPS3ReportEntity;
import com.toshaniFintech.user_service.repository.AEPS3ReportRepository;
import com.toshaniFintech.user_service.service.AEPS3ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AEPS3ReportServiceImpl implements AEPS3ReportService {
    @Autowired
    private AEPS3ReportRepository aeps3ReportRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<AEPS3ReportResponse> getAllAEPS3Report(PageRequest pageRequest) {
        List<AEPS3ReportEntity> aeps3ReportEntityList = aeps3ReportRepository.findAll();
        return aeps3ReportEntityList.stream().map
                (aeps3ReportEntity ->  objectMapper.convertValue(aeps3ReportEntity,
                        AEPS3ReportResponse.class)).toList();
    }
}
