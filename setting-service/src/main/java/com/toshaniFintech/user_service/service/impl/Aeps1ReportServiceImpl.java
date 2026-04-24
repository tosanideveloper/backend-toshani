package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.Aeps1ReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.Aeps1ReportResponseDTO;
import com.toshaniFintech.user_service.entity.Aeps1ReportEntity;
import com.toshaniFintech.user_service.mapper.Aeps1ReportMapper;
import com.toshaniFintech.user_service.repository.Aeps1ReportRepository;
import com.toshaniFintech.user_service.service.Aeps1ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Aeps1ReportServiceImpl implements Aeps1ReportService {

    @Autowired
    private Aeps1ReportRepository aeps1ReportRepository;

    @Autowired
    private Aeps1ReportMapper aeps1ReportMapper;

    @Override
    public PaginatedResponse<Aeps1ReportResponseDTO> fetchAepsReport(Aeps1ReportRequestDTO requestDTO) {

        PageRequest page = Utility.pageRequest(requestDTO.getPageNo(), requestDTO.getPageSize(), requestDTO.getSortBy(),
                requestDTO.getOrderBy());

        Page<Aeps1ReportEntity> paginatedContent = aeps1ReportRepository.fetchAepsReport(requestDTO.getStartDate(),
                requestDTO.getEndDate(), requestDTO.getOrderId(), requestDTO.getTxnId(), requestDTO.getTxnType(),
                requestDTO.getStatus(), requestDTO.getSearch(), requestDTO.getSearchByField(), page);

        List<Aeps1ReportResponseDTO> responseDTOS = new ArrayList<>();
        paginatedContent.getContent().forEach(content ->
                responseDTOS.add(aeps1ReportMapper.toResponseDto(content)));

        return Utility.paginatedResponseForSubList(paginatedContent.getNumber(), paginatedContent.getTotalPages(),
                paginatedContent.getSize(), paginatedContent.getNumberOfElements(), paginatedContent.getTotalElements(),
                responseDTOS);
    }
}