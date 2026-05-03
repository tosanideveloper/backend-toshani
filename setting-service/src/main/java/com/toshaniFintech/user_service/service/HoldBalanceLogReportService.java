package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.HoldBalanceLogReportRequest;
import com.toshaniFintech.user_service.dto.response.HoldBalanceLogReportResponse;

public interface HoldBalanceLogReportService {
    PaginatedResponse<HoldBalanceLogReportResponse> fetchHoldBalanceLogReport(HoldBalanceLogReportRequest request);
}
