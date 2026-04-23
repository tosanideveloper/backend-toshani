package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.DmtLite1ReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.DmtLite1ReportResponseDTO;
import com.toshaniFintech.user_service.entity.DmtLite1ReportEntity;
import com.toshaniFintech.user_service.mapper.DmtLite1ReportMapper;
import com.toshaniFintech.user_service.repository.DmtLite1ReportRepository;
import com.toshaniFintech.user_service.service.DmtLite1ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DmtLite1ReportServiceImpl implements DmtLite1ReportService {

    @Autowired
    private DmtLite1ReportRepository repository;

    @Autowired
    private DmtLite1ReportMapper mapper;

    @Override
    public PaginatedResponse<DmtLite1ReportResponseDTO> fetchDmtLite1Report(DmtLite1ReportRequestDTO requestDTO) {

        PageRequest page = Utility.pageRequest(
                requestDTO.getPageNo(),
                requestDTO.getPageSize(),
                requestDTO.getSortBy(),
                requestDTO.getOrderBy()
        );

        Page<DmtLite1ReportEntity> paginatedContent = repository.fetchDmtLite1Report(
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

        List<DmtLite1ReportResponseDTO> responseDTOS = new ArrayList<>();
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