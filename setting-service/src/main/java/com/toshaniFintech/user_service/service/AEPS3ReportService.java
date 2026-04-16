package com.toshaniFintech.user_service.service;

import com.toshaniFintech.user_service.dto.response.AEPS3ReportResponse;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface AEPS3ReportService {
    List<AEPS3ReportResponse> getAllAEPS3Report(PageRequest pageRequest);
}
