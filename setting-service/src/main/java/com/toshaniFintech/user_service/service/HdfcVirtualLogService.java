package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.HdfcVirtualLogRequest;
import com.toshaniFintech.user_service.dto.response.HdfcVirtualLogResponse;

public interface HdfcVirtualLogService {
    PaginatedResponse<HdfcVirtualLogResponse> fetchHdfcVirtualLog(HdfcVirtualLogRequest requestDTO);

}
