package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.AdminDebitWalletReportRequest;
import com.toshaniFintech.user_service.dto.response.AdminDebitWalletReportResponse;
import com.toshaniFintech.user_service.entity.AdminDebitWalletReportEntity;
import com.toshaniFintech.user_service.mapper.AdminDebitWalletReportMapper;
import com.toshaniFintech.user_service.repository.AdminDebitWalletReportRepository;
import com.toshaniFintech.user_service.service.AdminDebitWalletReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminDebitWalletReportServiceImpl implements AdminDebitWalletReportService {
    @Autowired
    private AdminDebitWalletReportRepository adminDebitWalletReportRepository;

    @Autowired
    private AdminDebitWalletReportMapper adminDebitWalletReportMapper;

    @Override
    public PaginatedResponse<AdminDebitWalletReportResponse> fetchAdminDebitWalletReport
            (AdminDebitWalletReportRequest request) {

        PageRequest page = Utility.pageRequest(request.getPageNo(), request.getPageSize(), request.getSortBy(),
                request.getOrderBy());

        Page<AdminDebitWalletReportEntity>
                paginatedContent = adminDebitWalletReportRepository.fetchAdminDebitWalletReport(request.getStartDate(),
                request.getEndDate(),request.getTxnId(),
                request.getSearch(), request.getSearchByField(), page);

        List<AdminDebitWalletReportResponse> response = new ArrayList<>();
        paginatedContent.getContent().forEach(content ->
                response.add(adminDebitWalletReportMapper.toResponse(content)));

        return Utility.paginatedResponseForSubList(paginatedContent.getNumber(), paginatedContent.getTotalPages(),
                paginatedContent.getSize(), paginatedContent.getNumberOfElements(), paginatedContent.getTotalElements(),
                response);
    }
}
