package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.ActivityReportRequest;
import com.toshaniFintech.user_service.dto.response.ActivityReportResponse;
import com.toshaniFintech.user_service.entity.ActivityReportEntity;
import com.toshaniFintech.user_service.repository.ActivityReportRepository;
import com.toshaniFintech.user_service.service.ActivityReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityReportServiceImpl implements ActivityReportService {
    @Autowired
    private ActivityReportRepository activityReportRepository;

    @Override
    public PaginatedResponse<ActivityReportResponse> getAllActivityReports(PageRequest pageRequest) {

        Page<ActivityReportEntity> settingPage = activityReportRepository.findAll(pageRequest);

        PaginatedResponse<ActivityReportResponse> response =
                new PaginatedResponse<>(settingPage);

        response.setContent(
                settingPage.getContent()
                        .stream()
                        .map(this::mapToModel)
                        .collect(Collectors.toList())
        );

        return response;
    }

    private ActivityReportEntity mapToEntity(ActivityReportRequest model) {
        ActivityReportEntity entity = new ActivityReportEntity();
        entity.setApiUserDetail(model.getApiUserDetail());
        entity.setUpdatedBy(model.getUpdatedBy());
        entity.setFunctionName(model.getFunctionName());
        return entity;
    }

    private ActivityReportResponse mapToModel(ActivityReportEntity entity) {
        ActivityReportResponse response = new ActivityReportResponse();
        response.setApiUserDetail(entity.getApiUserDetail());
        response.setUpdatedBy(entity.getUpdatedBy());
        response.setFunctionName(entity.getFunctionName());
        return response;
    }

    @Override
    public List<ActivityReportResponse> getAllActivityReport() {
        return List.of();
    }

    @Override
    public PaginatedResponse<ActivityReportResponse> getAllActivityReport(PageRequest pageRequest) {
        return null;
    }
}
