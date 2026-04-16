package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.response.AEPS2ReportResponse;
import com.toshaniFintech.user_service.entity.AEPS2ReportEntity;
import com.toshaniFintech.user_service.model.AEPS2ReportModel;
import com.toshaniFintech.user_service.repository.AEPS2ReportRepository;
import com.toshaniFintech.user_service.service.AEPS2ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AEPS2ReportServiceImpl implements AEPS2ReportService {
    @Autowired
    private AEPS2ReportRepository aeps2ReportRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<AEPS2ReportResponse> getAllAEPS2Report(PageRequest pageRequest) {
        List<AEPS2ReportEntity> aeps2ReportEntityList = aeps2ReportRepository.findAll();
        return aeps2ReportEntityList.stream().map
                (aeps2ReportEntity ->  objectMapper.convertValue(aeps2ReportEntity,
                        AEPS2ReportResponse.class)).toList();
    }
}
