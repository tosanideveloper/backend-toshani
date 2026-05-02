package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.AdminCreditWalletReportRequest;
import com.toshaniFintech.user_service.dto.response.AdminCreditWalletReportResponse;

public interface AdminCreditWalletReportService {
    PaginatedResponse<AdminCreditWalletReportResponse> fetchAdminCreditWalletReport(AdminCreditWalletReportRequest request);
}
