package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.RechargeReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.RechargeReportResponseDTO;
import com.toshaniFintech.user_service.entity.RechargeReportEntity;
import com.toshaniFintech.user_service.mapper.RechargeReportMapper;
import com.toshaniFintech.user_service.repository.RechargeReportRepository;
import com.toshaniFintech.user_service.service.RechargeReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RechargeReportServiceImpl implements RechargeReportService {

    @Autowired
    RechargeReportMapper rechargeReportMapper;
    @Autowired
    private RechargeReportRepository rechargeReportRepository;

    @Override
    public PaginatedResponse<RechargeReportResponseDTO> fetchRechargeReport(RechargeReportRequestDTO requestDTO) {
        PageRequest page = Utility.pageRequest(requestDTO.getPageNo(), requestDTO.getPageSize(), requestDTO.getSortBy(), requestDTO.getOrderBy());

        Page<RechargeReportEntity> paginatedContent = rechargeReportRepository.fetchRechargeReport(requestDTO.getStartDate(), requestDTO.getEndDate(), requestDTO.getOrderId(), requestDTO.getTxnId(), requestDTO.getTxnType(), requestDTO.getStatus(), requestDTO.getSearch(), requestDTO.getSearchByField(), page);

        List<RechargeReportResponseDTO> responseDTOS = new ArrayList<>();
        paginatedContent.getContent().forEach(content -> responseDTOS.add(rechargeReportMapper.toResponseDto(content)));

        return Utility.paginatedResponseForSubList(paginatedContent.getNumber(), paginatedContent.getTotalPages(), paginatedContent.getSize(), paginatedContent.getNumberOfElements(), paginatedContent.getTotalElements(), responseDTOS);
    }
}