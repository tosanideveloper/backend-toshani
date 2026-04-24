package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.UpiCollectReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.UpiCollectReportResponseDTO;
import com.toshaniFintech.user_service.entity.UpiCollectReportEntity;
import com.toshaniFintech.user_service.mapper.UpiCollectReportMapper;
import com.toshaniFintech.user_service.repository.UpiCollectReportRepository;
import com.toshaniFintech.user_service.service.UpiCollectReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UpiCollectReportServiceImpl implements UpiCollectReportService {

    @Autowired
    private UpiCollectReportRepository repository;

    @Autowired
    private UpiCollectReportMapper mapper;

    @Override
    public PaginatedResponse<UpiCollectReportResponseDTO> fetchUpiCollectReport(
            UpiCollectReportRequestDTO requestDTO) {

        PageRequest page = Utility.pageRequest(
                requestDTO.getPageNo(),
                requestDTO.getPageSize(),
                requestDTO.getSortBy(),
                requestDTO.getOrderBy()
        );

        Page<UpiCollectReportEntity> paginatedContent = repository.fetchUpiCollectReport(
                requestDTO.getStartDate(),
                requestDTO.getEndDate(),
                requestDTO.getRequestId(),
                requestDTO.getType(),
                requestDTO.getStatus(),
                requestDTO.getApiName(),
                requestDTO.getSearch(),
                requestDTO.getSearchByField(),
                page
        );

        List<UpiCollectReportResponseDTO> responseDTOS = new ArrayList<>();
        paginatedContent.getContent().forEach(content ->
                responseDTOS.add(mapper.toResponseDto(content))
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