package com.toshaniFintech.user_service.service;

import com.toshaniFintech.user_service.dto.response.AmcReportResponse;
import com.toshaniFintech.user_service.model.AmcReportModel;
import com.toshaniFintech.user_service.model.ApiPartnerServiceModel;

import java.util.List;

public interface AmcReportService {
    List<AmcReportModel> getAllAmcReport();
}
