package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.Aeps1ReportRequestDTO;
import com.toshaniFintech.user_service.dto.request.AmcReportRequest;
import com.toshaniFintech.user_service.dto.response.Aeps1ReportResponseDTO;
import com.toshaniFintech.user_service.dto.response.AmcReportResponse;
import com.toshaniFintech.user_service.model.AmcReportModel;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface AmcReportService {
    PaginatedResponse<AmcReportResponse> fetchAmcReport(AmcReportRequest request);
}
