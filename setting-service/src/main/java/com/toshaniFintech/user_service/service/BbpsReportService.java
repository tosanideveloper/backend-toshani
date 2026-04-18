package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.BbpsReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.BbpsReportResponseDTO;

public interface BbpsReportService {
    PaginatedResponse<BbpsReportResponseDTO> fetchBbpsReport(BbpsReportRequestDTO requestDTO);


}