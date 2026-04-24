package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.PayoutReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.PayoutReportResponseDTO;

public interface PayoutReportService {

    PaginatedResponse<PayoutReportResponseDTO> fetchPayoutReport(PayoutReportRequestDTO requestDTO);
}