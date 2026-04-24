package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.Dmt2ReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.Dmt2ReportResponseDTO;

public interface Dmt2ReportService {

    PaginatedResponse<Dmt2ReportResponseDTO> fetchDmt2Report(Dmt2ReportRequestDTO requestDTO);
}