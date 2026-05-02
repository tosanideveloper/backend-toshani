package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.SettlementReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.SettlementReportResponseDTO;

public interface SettlementReportService {
    PaginatedResponse<SettlementReportResponseDTO> fetchSettlementReport(SettlementReportRequestDTO requestDTO);

}
