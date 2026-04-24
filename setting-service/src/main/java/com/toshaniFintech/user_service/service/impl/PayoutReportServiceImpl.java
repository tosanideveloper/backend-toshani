package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.PayoutReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.PayoutReportResponseDTO;
import com.toshaniFintech.user_service.entity.PayoutReportEntity;
import com.toshaniFintech.user_service.mapper.PayoutReportMapper;
import com.toshaniFintech.user_service.repository.PayoutReportRepository;
import com.toshaniFintech.user_service.service.PayoutReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PayoutReportServiceImpl implements PayoutReportService {

    @Autowired
    private PayoutReportRepository repository;

    @Autowired
    private PayoutReportMapper mapper;

    @Override
    public PaginatedResponse<PayoutReportResponseDTO> fetchPayoutReport(PayoutReportRequestDTO requestDTO) {

        PageRequest page = Utility.pageRequest(
                requestDTO.getPageNo(),
                requestDTO.getPageSize(),
                requestDTO.getSortBy(),
                requestDTO.getOrderBy()
        );

        Page<PayoutReportEntity> paginatedContent = repository.fetchPayoutReport(
                requestDTO.getStartDate(),
                requestDTO.getEndDate(),
                requestDTO.getTransactionId(),
                requestDTO.getOrderId(),
                requestDTO.getApiTransactionId(),
                requestDTO.getAccountNumber(),
                requestDTO.getIfsc(),
                requestDTO.getBank(),
                requestDTO.getUtr(),
                requestDTO.getType(),
                requestDTO.getStatus(),
                requestDTO.getApiName(),
                requestDTO.getSearch(),
                requestDTO.getSearchByField(),
                page
        );

        List<PayoutReportResponseDTO> responseDTOS = new ArrayList<>();
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