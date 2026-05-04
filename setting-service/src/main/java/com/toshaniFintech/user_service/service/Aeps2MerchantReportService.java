package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.Aeps2MerchantReportRequest;
import com.toshaniFintech.user_service.dto.response.Aeps2MerchantReportResponse;

public interface Aeps2MerchantReportService {
    PaginatedResponse<Aeps2MerchantReportResponse> fetchAeps2MerchantReport(Aeps2MerchantReportRequest request);
}
