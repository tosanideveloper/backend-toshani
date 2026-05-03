package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.PartnerBalanceReportRequest;
import com.toshaniFintech.user_service.dto.response.PartnerBalanceReportResponse;

public interface PartnerBalanceReportService {
    PaginatedResponse<PartnerBalanceReportResponse> fetchPartnerBalanceReport(PartnerBalanceReportRequest request);
}
