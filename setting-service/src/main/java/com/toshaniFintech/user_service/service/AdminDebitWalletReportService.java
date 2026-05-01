package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.AdminDebitWalletReportRequest;
import com.toshaniFintech.user_service.dto.response.AdminDebitWalletReportResponse;

public interface AdminDebitWalletReportService {
    PaginatedResponse<AdminDebitWalletReportResponse> fetchAdminDebitWalletReport( AdminDebitWalletReportRequest request);

}
