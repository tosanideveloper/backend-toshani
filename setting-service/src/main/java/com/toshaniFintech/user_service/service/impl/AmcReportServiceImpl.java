package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.AmcReportRequest;
import com.toshaniFintech.user_service.dto.response.AmcReportResponse;
import com.toshaniFintech.user_service.entity.AmcReportEntity;
import com.toshaniFintech.user_service.mapper.AmcReportMapper;
import com.toshaniFintech.user_service.repository.AmcReportRepository;
import com.toshaniFintech.user_service.service.AmcReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AmcReportServiceImpl implements AmcReportService {

    @Autowired
    private AmcReportRepository amcReportRepository;

    @Autowired
    private AmcReportMapper amcReportMapper;


    @Override
    public PaginatedResponse<AmcReportResponse> fetchAmcReport(AmcReportRequest request) {

        PageRequest page = Utility.pageRequest(request.getPageNo(), request.getPageSize(), request.getSortBy(),
                request.getOrderBy());

        Page<AmcReportEntity> paginatedContent = amcReportRepository.fetchAmcReport(request.getStartDate(),
                request.getEndDate(),request.getTxnId(),
                request.getSearch(), request.getSearchByField(), page);

        List<AmcReportResponse> response = new ArrayList<>();
        paginatedContent.getContent().forEach(content ->
                response.add(amcReportMapper.toResponse(content)));

        return Utility.paginatedResponseForSubList(paginatedContent.getNumber(), paginatedContent.getTotalPages(),
                paginatedContent.getSize(), paginatedContent.getNumberOfElements(), paginatedContent.getTotalElements(),
                response);
    }

}
