package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.DmtLiteReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.DmtLiteReportResponseDTO;

public interface DmtLiteReportService {

    PaginatedResponse<DmtLiteReportResponseDTO> fetchDmtLiteReport(DmtLiteReportRequestDTO requestDTO);
}