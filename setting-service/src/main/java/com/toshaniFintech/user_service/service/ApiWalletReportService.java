package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.ApiWalletReportRequest;
import com.toshaniFintech.user_service.dto.response.ApiWalletReportResponse;

public interface ApiWalletReportService {
    PaginatedResponse<ApiWalletReportResponse> fetchApiWalletReport(ApiWalletReportRequest request);
}
