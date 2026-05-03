package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.PartnerBalanceReportRequest;
import com.toshaniFintech.user_service.dto.response.PartnerBalanceReportResponse;
import com.toshaniFintech.user_service.entity.PartnerBalanceReportEntity;
import com.toshaniFintech.user_service.mapper.PartnerBalanceReportMapper;
import com.toshaniFintech.user_service.repository.PartnerBalanceReportRepository;
import com.toshaniFintech.user_service.service.PartnerBalanceReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PartnerBalanceReportServiceImpl implements PartnerBalanceReportService {
    @Autowired
    private PartnerBalanceReportRepository partnerBalanceReportRepository;

    @Autowired
    private PartnerBalanceReportMapper partnerBalanceReportMapper;


    @Override
    public PaginatedResponse<PartnerBalanceReportResponse> fetchPartnerBalanceReport
            (PartnerBalanceReportRequest request) {

        PageRequest page = Utility.pageRequest(request.getPageNo(), request.getPageSize(), request.getSortBy(),
                request.getOrderBy());

        Page<PartnerBalanceReportEntity> paginatedContent =
                partnerBalanceReportRepository.fetchPartnerBalanceReport(request.getStartDate(),
                        request.getEndDate(), request.getUserId(),
                        request.getSearch(), request.getSearchByField(), page);

        List<PartnerBalanceReportResponse> response = new ArrayList<>();
        paginatedContent.getContent().forEach(content ->
                response.add(partnerBalanceReportMapper.toResponse(content)));

        return Utility.paginatedResponseForSubList(paginatedContent.getNumber(), paginatedContent.getTotalPages(),
                paginatedContent.getSize(), paginatedContent.getNumberOfElements(), paginatedContent.getTotalElements(),
                response);
    }
}
