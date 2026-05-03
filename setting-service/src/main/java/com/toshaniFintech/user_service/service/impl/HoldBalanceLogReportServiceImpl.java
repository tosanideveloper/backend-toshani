package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.HoldBalanceLogReportRequest;
import com.toshaniFintech.user_service.dto.response.HoldBalanceLogReportResponse;
import com.toshaniFintech.user_service.entity.HoldBalanceLogReportEntity;
import com.toshaniFintech.user_service.mapper.HoldBalanceLogReportMapper;
import com.toshaniFintech.user_service.repository.HoldBalanceLogReportRepository;
import com.toshaniFintech.user_service.service.HoldBalanceLogReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HoldBalanceLogReportServiceImpl implements HoldBalanceLogReportService {
    @Autowired
    private HoldBalanceLogReportRepository holdBalanceLogReportRepository;

    @Autowired
    private HoldBalanceLogReportMapper holdBalanceLogReportMapper;

    @Override
    public PaginatedResponse<HoldBalanceLogReportResponse>
    fetchHoldBalanceLogReport(HoldBalanceLogReportRequest request) {

        PageRequest page = Utility.pageRequest(request.getPageNo(), request.getPageSize(), request.getSortBy(),
                request.getOrderBy());

        Page<HoldBalanceLogReportEntity> paginatedContent = holdBalanceLogReportRepository.fetchHoldBalanceLogReport
                (request.getStartDate(), request.getEndDate(), request.getPartnerId(),
                        request.getSearch(), request.getSearchByField(), page);

        List<HoldBalanceLogReportResponse> response = new ArrayList<>();
        paginatedContent.getContent().forEach(content ->
                response.add(holdBalanceLogReportMapper.toResponse(content)));

        return Utility.paginatedResponseForSubList(paginatedContent.getNumber(), paginatedContent.getTotalPages(),
                paginatedContent.getSize(), paginatedContent.getNumberOfElements(), paginatedContent.getTotalElements(),
                response);
    }

}
