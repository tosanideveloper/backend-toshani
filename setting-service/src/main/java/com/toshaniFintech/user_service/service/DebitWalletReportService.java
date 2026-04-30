package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.DebitWalletReportRequest;
import com.toshaniFintech.user_service.dto.response.DebitWalletReportResponse;

public interface DebitWalletReportService {
    PaginatedResponse<DebitWalletReportResponse> fetchDebitWalletReport(DebitWalletReportRequest request);

}
