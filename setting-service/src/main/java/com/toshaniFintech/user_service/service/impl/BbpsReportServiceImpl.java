package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.BbpsReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.BbpsReportResponseDTO;
import com.toshaniFintech.user_service.entity.BbpsReportEntity;
import com.toshaniFintech.user_service.mapper.BbpsReportMapper;
import com.toshaniFintech.user_service.repository.BbpsReportRepository;
import com.toshaniFintech.user_service.service.BbpsReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BbpsReportServiceImpl implements BbpsReportService {

    @Autowired
    private BbpsReportRepository bbpsReportRepository;

    @Autowired
    BbpsReportMapper bbpsReportMapper;


    @Override
    public PaginatedResponse<BbpsReportResponseDTO> fetchBbpsReport(BbpsReportRequestDTO requestDTO) {
        PageRequest page = Utility.pageRequest(
                requestDTO.getPageNo(),
                requestDTO.getPageSize(),
                requestDTO.getSortBy(),
                requestDTO.getOrderBy()
        );

        Page<BbpsReportEntity> paginatedContent = bbpsReportRepository.fetchBbpsReport(
                requestDTO.getStartDate(),
                requestDTO.getEndDate(),
                requestDTO.getOrderId(),
                requestDTO.getTxnId(),
                requestDTO.getStatus(),
                requestDTO.getTxnType(),
                requestDTO.getSearch(),
                requestDTO.getSearchByField(),
                page
        );

        List<BbpsReportResponseDTO> responseDTOS = new ArrayList<>();
        paginatedContent.getContent().forEach(content ->
                responseDTOS.add(bbpsReportMapper.toResponseDto(content))
        );

        return Utility.paginatedResponseForSubList(
                paginatedContent.getNumber(),
                paginatedContent.getTotalPages(),
                paginatedContent.getSize(),
                paginatedContent.getNumberOfElements(),
                paginatedContent.getTotalElements(),
                responseDTOS
        );
    }
}