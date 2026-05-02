package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.ApiWalletReportRequest;
import com.toshaniFintech.user_service.dto.response.ApiWalletReportResponse;
import com.toshaniFintech.user_service.entity.ApiWalletReportEntity;
import com.toshaniFintech.user_service.mapper.ApiWalletReportMapper;
import com.toshaniFintech.user_service.repository.ApiWalletReportRepository;
import com.toshaniFintech.user_service.service.ApiWalletReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiWalletServiceImpl implements ApiWalletReportService {
    @Autowired
    private ApiWalletReportRepository apiWalletReportRepository;

    @Autowired
    private ApiWalletReportMapper apiWalletReportMapper;

    @Override
    public PaginatedResponse<ApiWalletReportResponse> fetchApiWalletReport
            (ApiWalletReportRequest request) {

        PageRequest page = Utility.pageRequest(request.getPageNo(), request.getPageSize(), request.getSortBy(),
                request.getOrderBy());

        Page<ApiWalletReportEntity>
                paginatedContent = apiWalletReportRepository.fetchApiWalletReport(request.getStartDate(),
                request.getEndDate(),request.getTxnId(),
                request.getSearch(), request.getSearchByField(), page);

        List<ApiWalletReportResponse> response = new ArrayList<>();
        paginatedContent.getContent().forEach(content ->
                response.add(apiWalletReportMapper.toResponse(content)));

        return Utility.paginatedResponseForSubList(paginatedContent.getNumber(), paginatedContent.getTotalPages(),
                paginatedContent.getSize(), paginatedContent.getNumberOfElements(), paginatedContent.getTotalElements(),
                response);
    }
}
