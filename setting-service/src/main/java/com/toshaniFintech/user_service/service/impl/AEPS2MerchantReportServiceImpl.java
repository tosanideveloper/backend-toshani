package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.user_service.dto.response.AEPS2MerchantReportResponse;
import com.toshaniFintech.user_service.entity.AEPS2MerchantReportEntity;
import com.toshaniFintech.user_service.repository.AEPS2MerchantReportRepository;
import com.toshaniFintech.user_service.service.AEPS2MerchantReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AEPS2MerchantReportServiceImpl implements AEPS2MerchantReportService {
    @Autowired
    private AEPS2MerchantReportRepository aeps2MerchantReportRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<AEPS2MerchantReportResponse> getAllAEPS2MerchantReport(PageRequest pageRequest) {
        List<AEPS2MerchantReportEntity> aeps2MerchantReportEntityList = aeps2MerchantReportRepository.findAll();
        return aeps2MerchantReportEntityList.stream().map
                (aeps2MerchantReportEntity ->  objectMapper.convertValue(aeps2MerchantReportEntity,
                        AEPS2MerchantReportResponse.class)).toList();
    }

}
