package com.toshaniFintech.user_service.service;

import com.toshaniFintech.user_service.dto.request.ModifyReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.ModifyReportResponseDTO;

import java.util.List;

public interface ModifyReportService {

    List<ModifyReportResponseDTO> getModifyReport(ModifyReportRequestDTO requestDTO);

}