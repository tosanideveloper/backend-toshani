package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.response.ActivityReportResponse;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ActivityReportService {
    PaginatedResponse<ActivityReportResponse> getAllActivityReports(PageRequest pageRequest);

    List<ActivityReportResponse> getAllActivityReport();

    PaginatedResponse<ActivityReportResponse> getAllActivityReport(PageRequest pageRequest);
}
