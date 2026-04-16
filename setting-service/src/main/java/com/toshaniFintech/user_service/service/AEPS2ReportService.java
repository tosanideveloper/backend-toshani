package com.toshaniFintech.user_service.service;

import com.toshaniFintech.user_service.dto.response.AEPS2ReportResponse;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface AEPS2ReportService {
    List<AEPS2ReportResponse> getAllAEPS2Report(PageRequest pageRequest);
}
