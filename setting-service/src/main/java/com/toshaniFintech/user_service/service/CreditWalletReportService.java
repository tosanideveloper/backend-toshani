package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.CreditWalletReportRequest;
import com.toshaniFintech.user_service.dto.response.CreditWalletReportResponse;

public interface CreditWalletReportService {
    PaginatedResponse<CreditWalletReportResponse> fetchCreditWalletReport(CreditWalletReportRequest request);

}
