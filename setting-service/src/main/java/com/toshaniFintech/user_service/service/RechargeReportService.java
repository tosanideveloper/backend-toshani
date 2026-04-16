package com.toshaniFintech.user_service.service;

import com.toshaniFintech.user_service.dto.request.RechargeReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.RechargeReportResponseDTO;

import java.util.List;

public interface RechargeReportService {

    List<RechargeReportResponseDTO> getRechargeReport(RechargeReportRequestDTO requestDTO);

}