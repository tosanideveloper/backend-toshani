package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.TransactionLogBackupReportRequest;
import com.toshaniFintech.user_service.dto.response.TransactionLogBackupReportResponse;
import com.toshaniFintech.user_service.entity.TransactionLogBackupReportEntity;
import com.toshaniFintech.user_service.mapper.TransactionLogBackupReportMapper;
import com.toshaniFintech.user_service.repository.TransactionLogBackupReportRepository;
import com.toshaniFintech.user_service.service.TransactionLogBackupReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionLogBackupReportServiceImpl implements TransactionLogBackupReportService {
    @Autowired
    private TransactionLogBackupReportRepository transactionLogBackupReportRepository ;

    @Autowired
    private TransactionLogBackupReportMapper transactionLogBackupReportMapper;

    @Override
    public PaginatedResponse<TransactionLogBackupReportResponse> fetchTransactionLogBackupReport
            (TransactionLogBackupReportRequest request) {

        PageRequest page = Utility.pageRequest(request.getPageNo(), request.getPageSize(), request.getSortBy(),
                request.getOrderBy());

        Page<TransactionLogBackupReportEntity> paginatedContent =
                transactionLogBackupReportRepository.fetchTransactionLogBackupReport(request.getStartDate(),
                request.getEndDate(), request.getOrderId(), request.getTxnId(), request.getTxnType(),
                request.getStatus(), request.getSearch(), request.getSearchByField(), page);

        List<TransactionLogBackupReportResponse> response = new ArrayList<>();
        paginatedContent.getContent().forEach(content ->
                response.add(transactionLogBackupReportMapper.toResponse(content)));

        return Utility.paginatedResponseForSubList(paginatedContent.getNumber(), paginatedContent.getTotalPages(),
                paginatedContent.getSize(), paginatedContent.getNumberOfElements(), paginatedContent.getTotalElements(),
                response);
    }
}
