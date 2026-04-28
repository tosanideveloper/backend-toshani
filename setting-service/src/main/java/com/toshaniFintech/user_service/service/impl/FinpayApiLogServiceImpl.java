package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.FinpayApiLogRequest;
import com.toshaniFintech.user_service.dto.response.FinpayApiLogResponse;
import com.toshaniFintech.user_service.entity.FinpayApiLogEntity;
import com.toshaniFintech.user_service.mapper.FinpayApiLogMapper;
import com.toshaniFintech.user_service.repository.FinpayApiLogRepository;
import com.toshaniFintech.user_service.service.FinpayApiLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FinpayApiLogServiceImpl implements FinpayApiLogService {
    @Autowired
    private FinpayApiLogRepository finpayApiLogRepository;

    @Autowired
    private FinpayApiLogMapper finpayApiLogMapper;

    @Override
    public PaginatedResponse<FinpayApiLogResponse> fetchFinpayApiLog(FinpayApiLogRequest request) {

        PageRequest page = Utility.pageRequest(request.getPageNo(), request.getPageSize(), request.getSortBy(),
                request.getOrderBy());

        Page<FinpayApiLogEntity> paginatedContent = finpayApiLogRepository.fetchFinpayApiLog(request.getStartDate(),
                request.getEndDate(), request.getPartnerId() ,request.getSearch(), request.getSearchByField(), page);

        List<FinpayApiLogResponse> response = new ArrayList<>();
        paginatedContent.getContent().forEach(content ->
                response.add(finpayApiLogMapper.toResponse(content)));

        return Utility.paginatedResponseForSubList(paginatedContent.getNumber(), paginatedContent.getTotalPages(),
                paginatedContent.getSize(), paginatedContent.getNumberOfElements(), paginatedContent.getTotalElements(),
                response);
    }
}
