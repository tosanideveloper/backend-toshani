package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.Dmt3ReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.Dmt3ReportResponseDTO;

public interface Dmt3ReportService {

    PaginatedResponse<Dmt3ReportResponseDTO> fetchDmt3Report(Dmt3ReportRequestDTO requestDTO);
}