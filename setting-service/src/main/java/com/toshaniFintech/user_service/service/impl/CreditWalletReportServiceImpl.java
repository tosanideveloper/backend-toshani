package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.CreditWalletReportRequest;
import com.toshaniFintech.user_service.dto.response.CreditWalletReportResponse;
import com.toshaniFintech.user_service.entity.CreditWalletReportEntity;
import com.toshaniFintech.user_service.mapper.CreditWalletReportMapper;
import com.toshaniFintech.user_service.repository.CreditWalletReportRepository;
import com.toshaniFintech.user_service.service.CreditWalletReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreditWalletReportServiceImpl implements CreditWalletReportService {
    @Autowired
    private CreditWalletReportRepository creditWalletReportRepository;

    @Autowired
    private CreditWalletReportMapper creditWalletReportMapper;

    @Override
    public PaginatedResponse<CreditWalletReportResponse> fetchCreditWalletReport(CreditWalletReportRequest request) {

        PageRequest page = Utility.pageRequest(request.getPageNo(), request.getPageSize(), request.getSortBy(),
                request.getOrderBy());

        Page<CreditWalletReportEntity> paginatedContent =
                creditWalletReportRepository.fetchCreditWalletReport(request.getStartDate(),
                request.getEndDate(), request.getApiTxnId(), request.getTxnId(),
                request.getStatus(), request.getSearch(), request.getSearchByField(), page);

        List<CreditWalletReportResponse> response = new ArrayList<>();
        paginatedContent.getContent().forEach(content ->
                response.add(creditWalletReportMapper.toResponse(content)));

        return Utility.paginatedResponseForSubList(paginatedContent.getNumber(), paginatedContent.getTotalPages(),
                paginatedContent.getSize(), paginatedContent.getNumberOfElements(), paginatedContent.getTotalElements(),
                response);
    }
}
