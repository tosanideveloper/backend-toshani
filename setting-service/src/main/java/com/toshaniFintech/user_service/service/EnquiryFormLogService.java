package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.EnquiryFormLogRequest;
import com.toshaniFintech.user_service.dto.response.EnquiryFormLogResponse;

public interface EnquiryFormLogService {
    PaginatedResponse<EnquiryFormLogResponse> fetchEnquiryFormLog(EnquiryFormLogRequest request);

}
