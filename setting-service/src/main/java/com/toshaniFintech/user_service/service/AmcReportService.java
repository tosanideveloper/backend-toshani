package com.toshaniFintech.user_service.service;

import com.toshaniFintech.user_service.model.AmcReportModel;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface AmcReportService {
    List<AmcReportModel> getAllAmcReport(PageRequest pageRequest);
}
