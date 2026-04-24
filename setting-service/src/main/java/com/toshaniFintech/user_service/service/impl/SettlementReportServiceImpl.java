package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.SettlementReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.SettlementReportResponseDTO;
import com.toshaniFintech.user_service.entity.SettlementReportEntity;
import com.toshaniFintech.user_service.mapper.SettlementReportMapper;
import com.toshaniFintech.user_service.repository.SettlementReportRepository;
import com.toshaniFintech.user_service.service.SettlementReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SettlementReportServiceImpl implements SettlementReportService {
    @Autowired
    private SettlementReportRepository settlementReportRepository;

    @Autowired
    private SettlementReportMapper settlementReportMapper;

    @Override
    public PaginatedResponse<SettlementReportResponseDTO> fetchSettlementReport(SettlementReportRequestDTO requestDTO) {
        PageRequest page = Utility.pageRequest(requestDTO.getPageNo(), requestDTO.getPageSize(), requestDTO.getSortBy(), requestDTO.getOrderBy());

        Page<SettlementReportEntity> paginatedContent = settlementReportRepository.fetchSettlementReport(requestDTO.getStartDate(), requestDTO.getEndDate(), requestDTO.getOrderId(), requestDTO.getTxnId(), requestDTO.getTxnType(), requestDTO.getStatus(), requestDTO.getSearch(), requestDTO.getSearchByField(), page);

        List<SettlementReportResponseDTO> responseDTOS = new ArrayList<>();
        paginatedContent.getContent().forEach(content -> responseDTOS.add(settlementReportMapper.toResponseDto(content)));

        return Utility.paginatedResponseForSubList(paginatedContent.getNumber(), paginatedContent.getTotalPages(), paginatedContent.getSize(), paginatedContent.getNumberOfElements(), paginatedContent.getTotalElements(), responseDTOS);
    }
}
