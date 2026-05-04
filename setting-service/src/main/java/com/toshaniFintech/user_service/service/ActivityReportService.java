package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.ActivityReportRequest;
import com.toshaniFintech.user_service.dto.response.ActivityReportResponse;

public interface ActivityReportService {
    PaginatedResponse<ActivityReportResponse> fetchActivityReport(ActivityReportRequest request);

}
