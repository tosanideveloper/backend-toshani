package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.Dmt2ReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.Dmt2ReportResponseDTO;
import com.toshaniFintech.user_service.entity.Dmt2ReportEntity;
import com.toshaniFintech.user_service.mapper.Dmt2ReportMapper;
import com.toshaniFintech.user_service.repository.Dmt2ReportRepository;
import com.toshaniFintech.user_service.service.Dmt2ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Dmt2ReportServiceImpl implements Dmt2ReportService {

    @Autowired
    private Dmt2ReportRepository repository;

    @Autowired
    private Dmt2ReportMapper mapper;

    @Override
    public PaginatedResponse<Dmt2ReportResponseDTO> fetchDmt2Report(Dmt2ReportRequestDTO requestDTO) {

        PageRequest page = Utility.pageRequest(
                requestDTO.getPageNo(),
                requestDTO.getPageSize(),
                requestDTO.getSortBy(),
                requestDTO.getOrderBy()
        );

        Page<Dmt2ReportEntity> paginatedContent = repository.fetchDmt2Report(
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

        List<Dmt2ReportResponseDTO> responseDTOS = new ArrayList<>();
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