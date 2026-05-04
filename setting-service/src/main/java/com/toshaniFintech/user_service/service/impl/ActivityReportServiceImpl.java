package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.ActivityReportRequest;
import com.toshaniFintech.user_service.dto.response.ActivityReportResponse;
import com.toshaniFintech.user_service.entity.ActivityReportEntity;
import com.toshaniFintech.user_service.mapper.ActivityReportMapper;
import com.toshaniFintech.user_service.repository.ActivityReportRepository;
import com.toshaniFintech.user_service.service.ActivityReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityReportServiceImpl implements ActivityReportService {
    @Autowired
    private ActivityReportRepository activityReportRepository;

    @Autowired
    private ActivityReportMapper activityReportMapper;

    @Override
    public PaginatedResponse<ActivityReportResponse> fetchActivityReport(ActivityReportRequest request) {

        PageRequest page = Utility.pageRequest(request.getPageNo(), request.getPageSize(), request.getSortBy(),
                request.getOrderBy());

        Page<ActivityReportEntity> paginatedContent = activityReportRepository.fetchActivityReport(request.getStartDate(),
                request.getEndDate(),
                request.getSearch(), request.getSearchByField(), page);

        List<ActivityReportResponse> response = new ArrayList<>();
        paginatedContent.getContent().forEach(content ->
                response.add(activityReportMapper.toResponse(content)));

        return Utility.paginatedResponseForSubList(paginatedContent.getNumber(), paginatedContent.getTotalPages(),
                paginatedContent.getSize(), paginatedContent.getNumberOfElements(), paginatedContent.getTotalElements(),
                response);
    }
}
