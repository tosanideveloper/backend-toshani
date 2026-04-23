package com.toshaniFintech.user_service.service;

import com.toshaniFintech.user_service.dto.request.VerificationReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.VerificationReportResponseDTO;

import java.util.List;

public interface VerificationReportService {

    List<VerificationReportResponseDTO> getVerificationReport(VerificationReportRequestDTO requestDTO);

}