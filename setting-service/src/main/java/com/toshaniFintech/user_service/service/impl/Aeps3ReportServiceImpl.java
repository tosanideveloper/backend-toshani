package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.Aeps3ReportRequest;
import com.toshaniFintech.user_service.dto.response.Aeps3ReportResponse;
import com.toshaniFintech.user_service.entity.Aeps3ReportEntity;
import com.toshaniFintech.user_service.mapper.Aeps3ReportMapper;
import com.toshaniFintech.user_service.repository.Aeps3ReportRepository;
import com.toshaniFintech.user_service.service.Aeps3ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class Aeps3ReportServiceImpl implements Aeps3ReportService {
    @Autowired
    private Aeps3ReportRepository aeps3ReportRepository;
    @Autowired
    private Aeps3ReportMapper aeps3ReportMapper;

    @Override
    public PaginatedResponse<Aeps3ReportResponse> fetchAeps3Report(Aeps3ReportRequest request) {

        PageRequest page = Utility.pageRequest(request.getPageNo(), request.getPageSize(), request.getSortBy(),
                request.getOrderBy());

        Page<Aeps3ReportEntity> paginatedContent = aeps3ReportRepository.fetchAeps3Report(request.getStartDate(),
                request.getEndDate(), request.getOrderId(), request.getTxnId(), request.getTxnType(),
                request.getStatus(), request.getSearch(), request.getSearchByField(), page);

        List<Aeps3ReportResponse> response = new ArrayList<>();
        paginatedContent.getContent().forEach(content ->
                response.add(aeps3ReportMapper.toResponse(content)));

        return Utility.paginatedResponseForSubList(paginatedContent.getNumber(), paginatedContent.getTotalPages(),
                paginatedContent.getSize(), paginatedContent.getNumberOfElements(), paginatedContent.getTotalElements(),
                response);
    }
}
