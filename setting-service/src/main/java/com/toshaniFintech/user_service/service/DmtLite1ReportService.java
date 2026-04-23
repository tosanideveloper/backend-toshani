package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.DmtLite1ReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.DmtLite1ReportResponseDTO;

public interface DmtLite1ReportService {

    PaginatedResponse<DmtLite1ReportResponseDTO> fetchDmtLite1Report(DmtLite1ReportRequestDTO requestDTO);
}