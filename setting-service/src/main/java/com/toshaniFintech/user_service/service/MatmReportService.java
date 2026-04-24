package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.Aeps1ReportRequestDTO;
import com.toshaniFintech.user_service.dto.request.MatmReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.Aeps1ReportResponseDTO;
import com.toshaniFintech.user_service.dto.response.MatmReportResponseDTO;

import java.util.List;

public interface MatmReportService {
    PaginatedResponse<MatmReportResponseDTO> fetchMatmReport(MatmReportRequestDTO requestDTO);

}