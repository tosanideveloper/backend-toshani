package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.Aeps2ReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.Aeps2ReportResponseDTO;
import com.toshaniFintech.user_service.entity.Aeps2ReportEntity;
import com.toshaniFintech.user_service.mapper.AePSTwoReportMapper;
import com.toshaniFintech.user_service.repository.Aeps2ReportRepository;
import com.toshaniFintech.user_service.service.Aeps2ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Aeps2ReportServiceImpl implements Aeps2ReportService {

    @Autowired
    private Aeps2ReportRepository aeps2ReportRepository;

    @Autowired
    private AePSTwoReportMapper aePSTwoReportMapper;

    @Override
    public PaginatedResponse<Aeps2ReportResponseDTO> fetchAePSTwoReport(Aeps2ReportRequestDTO requestDTO) {

        PageRequest page = Utility.pageRequest(requestDTO.getPageNo(), requestDTO.getPageSize(), requestDTO.getSortBy(), requestDTO.getOrderBy());

        Page<Aeps2ReportEntity> paginatedContent = aeps2ReportRepository.fetchAePSTwoReport(requestDTO.getStartDate(), requestDTO.getEndDate(), requestDTO.getOrderId(), requestDTO.getTxnId(), requestDTO.getTxnType(), requestDTO.getStatus(), requestDTO.getSearch(), requestDTO.getSearchByField(), page);

        List<Aeps2ReportResponseDTO> responseDTOS = new ArrayList<>();
        paginatedContent.getContent().forEach(content -> responseDTOS.add(aePSTwoReportMapper.toResponseDto(content)));

        return Utility.paginatedResponseForSubList(paginatedContent.getNumber(), paginatedContent.getTotalPages(), paginatedContent.getSize(), paginatedContent.getNumberOfElements(), paginatedContent.getTotalElements(), responseDTOS);
    }
}