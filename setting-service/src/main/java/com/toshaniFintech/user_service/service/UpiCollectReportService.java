package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.UpiCollectReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.UpiCollectReportResponseDTO;

public interface UpiCollectReportService {

    PaginatedResponse<UpiCollectReportResponseDTO> fetchUpiCollectReport(UpiCollectReportRequestDTO requestDTO);
}