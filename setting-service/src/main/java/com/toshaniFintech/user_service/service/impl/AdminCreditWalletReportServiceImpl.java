package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.AdminCreditWalletReportRequest;
import com.toshaniFintech.user_service.dto.response.AdminCreditWalletReportResponse;
import com.toshaniFintech.user_service.entity.AdminCreditWalletReportEntity;
import com.toshaniFintech.user_service.mapper.AdminCreditWalletReportMapper;
import com.toshaniFintech.user_service.repository.AdminCreditWalletReportRepository;
import com.toshaniFintech.user_service.service.AdminCreditWalletReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminCreditWalletReportServiceImpl implements AdminCreditWalletReportService {
    @Autowired
    private AdminCreditWalletReportRepository adminCreditWalletReportRepository;

    @Autowired
    private AdminCreditWalletReportMapper adminCreditWalletReportMapper;

    @Override
    public PaginatedResponse<AdminCreditWalletReportResponse> fetchAdminCreditWalletReport
            (AdminCreditWalletReportRequest request) {

        PageRequest page = Utility.pageRequest(request.getPageNo(), request.getPageSize(), request.getSortBy(),
                request.getOrderBy());

        Page<AdminCreditWalletReportEntity>
                paginatedContent = adminCreditWalletReportRepository.fetchAdminCreditWalletReport(request.getStartDate(),
                request.getEndDate(),request.getTxnId(),
                request.getSearch(), request.getSearchByField(), page);

        List<AdminCreditWalletReportResponse> response = new ArrayList<>();
        paginatedContent.getContent().forEach(content ->
                response.add(adminCreditWalletReportMapper.toResponse(content)));

        return Utility.paginatedResponseForSubList(paginatedContent.getNumber(), paginatedContent.getTotalPages(),
                paginatedContent.getSize(), paginatedContent.getNumberOfElements(), paginatedContent.getTotalElements(),
                response);
    }
}
