package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.DmtLiteReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.DmtLiteReportResponseDTO;
import com.toshaniFintech.user_service.entity.DmtLiteReportEntity;
import com.toshaniFintech.user_service.mapper.DmtLiteReportMapper;
import com.toshaniFintech.user_service.repository.DmtLiteReportRepository;
import com.toshaniFintech.user_service.service.DmtLiteReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DmtLiteReportServiceImpl implements DmtLiteReportService {

    @Autowired
    private DmtLiteReportRepository repository;

    @Autowired
    private DmtLiteReportMapper mapper;

    @Override
    public PaginatedResponse<DmtLiteReportResponseDTO> fetchDmtLiteReport(DmtLiteReportRequestDTO requestDTO) {

        PageRequest page = Utility.pageRequest(
                requestDTO.getPageNo(),
                requestDTO.getPageSize(),
                requestDTO.getSortBy(),
                requestDTO.getOrderBy()
        );

        Page<DmtLiteReportEntity> paginatedContent = repository.fetchDmtLiteReport(
                requestDTO.getStartDate(),
                requestDTO.getEndDate(),
                requestDTO.getTransactionId(),
                requestDTO.getOrderId(),
                requestDTO.getAccountNumber(),
                requestDTO.getIfsc(),
                requestDTO.getUtr(),
                requestDTO.getType(),
                requestDTO.getStatus(),
                requestDTO.getApiName(),
                requestDTO.getSearch(),
                requestDTO.getSearchByField(),
                page
        );

        List<DmtLiteReportResponseDTO> responseDTOS = new ArrayList<>();
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