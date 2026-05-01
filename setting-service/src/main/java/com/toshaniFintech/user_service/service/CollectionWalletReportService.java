package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.CollectionWalletReportRequest;
import com.toshaniFintech.user_service.dto.response.CollectionWalletReportResponse;

public interface CollectionWalletReportService {
    PaginatedResponse<CollectionWalletReportResponse> fetchCollectionWalletReport(CollectionWalletReportRequest request);

}
