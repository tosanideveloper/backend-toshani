package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.TransactionLogBackupReportRequest;
import com.toshaniFintech.user_service.dto.response.TransactionLogBackupReportResponse;

public interface TransactionLogBackupReportService {
    PaginatedResponse<TransactionLogBackupReportResponse> fetchTransactionLogBackupReport
            (TransactionLogBackupReportRequest request);

}
