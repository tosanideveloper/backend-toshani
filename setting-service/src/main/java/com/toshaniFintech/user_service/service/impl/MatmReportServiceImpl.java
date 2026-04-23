package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.MatmReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.Aeps2ReportResponseDTO;
import com.toshaniFintech.user_service.dto.response.MatmReportResponseDTO;
import com.toshaniFintech.user_service.entity.Aeps2ReportEntity;
import com.toshaniFintech.user_service.entity.MatmReportEntity;
import com.toshaniFintech.user_service.mapper.MatmReportMapper;
import com.toshaniFintech.user_service.repository.MatmReportRepository;
import com.toshaniFintech.user_service.service.MatmReportService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatmReportServiceImpl implements MatmReportService {

    @Autowired
    private MatmReportRepository matmReportRepository;

    @Autowired
    private MatmReportMapper matmReportMapper;


    @Override
    public PaginatedResponse<MatmReportResponseDTO> fetchMatmReport(MatmReportRequestDTO requestDTO) {
        PageRequest page = Utility.pageRequest(
                requestDTO.getPageNo(),
                requestDTO.getPageSize(),
                requestDTO.getSortBy(),
                requestDTO.getOrderBy()
        );

        Page<MatmReportEntity> paginatedContent = matmReportRepository.fetchMatmReport(
                requestDTO.getStartDate(),
                requestDTO.getEndDate(),
                requestDTO.getOrderId(),
                requestDTO.getTxnId(),
                requestDTO.getTxnType(),
                requestDTO.getStatus(),
                requestDTO.getSearch(),
                requestDTO.getSearchByField(),
                page
        );

        List<MatmReportResponseDTO> responseDTOS = new ArrayList<>();
        paginatedContent.getContent().forEach(content ->
                responseDTOS.add(matmReportMapper.toResponseDto(content))
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