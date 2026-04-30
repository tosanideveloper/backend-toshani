package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.DebitWalletReportRequest;
import com.toshaniFintech.user_service.dto.response.DebitWalletReportResponse;
import com.toshaniFintech.user_service.entity.DebitWalletReportEntity;
import com.toshaniFintech.user_service.mapper.DebitWalletReportMapper;
import com.toshaniFintech.user_service.repository.DebitWalletReportRepository;
import com.toshaniFintech.user_service.service.DebitWalletReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DebitWalletReportServiceImpl implements DebitWalletReportService {
    @Autowired
    private DebitWalletReportRepository debitWalletReportRepository;

    @Autowired
    private DebitWalletReportMapper debitWalletReportMapper;

    @Override
    public PaginatedResponse<DebitWalletReportResponse> fetchDebitWalletReport(DebitWalletReportRequest request) {

        PageRequest page = Utility.pageRequest(request.getPageNo(), request.getPageSize(), request.getSortBy(),
                request.getOrderBy());

        Page<DebitWalletReportEntity> paginatedContent =
                debitWalletReportRepository.fetchDebitWalletReport(request.getStartDate(),
                        request.getEndDate(), request.getApiTxnId(), request.getTxnId(),
                        request.getStatus(), request.getSearch(), request.getSearchByField(), page);

        List<DebitWalletReportResponse> response = new ArrayList<>();
        paginatedContent.getContent().forEach(content ->
                response.add(debitWalletReportMapper.toResponse(content)));

        return Utility.paginatedResponseForSubList(paginatedContent.getNumber(), paginatedContent.getTotalPages(),
                paginatedContent.getSize(), paginatedContent.getNumberOfElements(), paginatedContent.getTotalElements(),
                response);
    }
}
