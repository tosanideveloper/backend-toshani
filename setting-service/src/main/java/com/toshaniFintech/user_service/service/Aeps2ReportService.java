package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.Aeps2ReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.Aeps2ReportResponseDTO;

public interface Aeps2ReportService {
    PaginatedResponse<Aeps2ReportResponseDTO> fetchAePSTwoReport(Aeps2ReportRequestDTO requestDTO);

}