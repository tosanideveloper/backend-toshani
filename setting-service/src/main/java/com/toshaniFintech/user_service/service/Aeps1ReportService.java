package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.Aeps1ReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.Aeps1ReportResponseDTO;

public interface Aeps1ReportService {

    PaginatedResponse<Aeps1ReportResponseDTO> fetchAepsReport(Aeps1ReportRequestDTO requestDTO);
}