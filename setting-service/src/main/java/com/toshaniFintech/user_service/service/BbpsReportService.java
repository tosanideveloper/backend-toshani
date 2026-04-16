package com.toshaniFintech.user_service.service;

import com.toshaniFintech.user_service.dto.request.BbpsReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.BbpsReportResponseDTO;

import java.util.List;

public interface BbpsReportService {

    List<BbpsReportResponseDTO> getBbpsReport(BbpsReportRequestDTO requestDTO);

}