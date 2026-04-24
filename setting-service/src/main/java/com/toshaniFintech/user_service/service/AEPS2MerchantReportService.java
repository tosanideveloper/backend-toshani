package com.toshaniFintech.user_service.service;

import com.toshaniFintech.user_service.dto.response.AEPS2MerchantReportResponse;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface AEPS2MerchantReportService {
    List<AEPS2MerchantReportResponse> getAllAEPS2MerchantReport(PageRequest pageRequest);
}
