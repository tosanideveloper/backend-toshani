package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.Dmt3ReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.Dmt3ReportResponseDTO;
import com.toshaniFintech.user_service.entity.Dmt3ReportEntity;
import com.toshaniFintech.user_service.mapper.Dmt3ReportMapper;
import com.toshaniFintech.user_service.repository.Dmt3ReportRepository;
import com.toshaniFintech.user_service.service.Dmt3ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Dmt3ReportServiceImpl implements Dmt3ReportService {

    @Autowired
    private Dmt3ReportRepository repository;

    @Autowired
    private Dmt3ReportMapper mapper;

    @Override
    public PaginatedResponse<Dmt3ReportResponseDTO> fetchDmt3Report(Dmt3ReportRequestDTO requestDTO) {

        PageRequest page = Utility.pageRequest(
                requestDTO.getPageNo(),
                requestDTO.getPageSize(),
                requestDTO.getSortBy(),
                requestDTO.getOrderBy()
        );

        Page<Dmt3ReportEntity> paginatedContent = repository.fetchDmt3Report(
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

        List<Dmt3ReportResponseDTO> responseDTOS = new ArrayList<>();
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