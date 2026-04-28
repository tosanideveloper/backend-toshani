package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.FinpayApiLogRequest;
import com.toshaniFintech.user_service.dto.response.FinpayApiLogResponse;

public interface FinpayApiLogService {
    PaginatedResponse<FinpayApiLogResponse> fetchFinpayApiLog(FinpayApiLogRequest request);

}
