package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.model.Aeps1ReportModel;

public interface Aeps1ReportService {

    PaginatedResponse<Aeps1ReportModel> createAepsReport(Aeps1ReportModel aeps1ReportModel);
}