package com.toshaniFintech.user_service.service;

import com.toshaniFintech.user_service.dto.request.MatmReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.MatmReportResponseDTO;

import java.util.List;

public interface MatmReportService {

    List<MatmReportResponseDTO> getMatmReport(MatmReportRequestDTO requestDTO);

}