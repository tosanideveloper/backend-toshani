package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.Aeps3ReportRequest;
import com.toshaniFintech.user_service.dto.response.Aeps3ReportResponse;

public interface Aeps3ReportService {
    PaginatedResponse<Aeps3ReportResponse> fetchAeps3Report(Aeps3ReportRequest request);
}
