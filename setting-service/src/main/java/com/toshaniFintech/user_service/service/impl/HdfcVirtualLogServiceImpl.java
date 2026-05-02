package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.HdfcVirtualLogRequest;
import com.toshaniFintech.user_service.dto.response.HdfcVirtualLogResponse;
import com.toshaniFintech.user_service.entity.HdfcVirtualLogEntity;
import com.toshaniFintech.user_service.mapper.HdfcVirtualLogMapper;
import com.toshaniFintech.user_service.repository.HdfcVirtualLogRepository;
import com.toshaniFintech.user_service.service.HdfcVirtualLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class HdfcVirtualLogServiceImpl implements HdfcVirtualLogService {
    @Autowired
    private HdfcVirtualLogRepository hdfcVirtualLogRepository;

    @Autowired
    private HdfcVirtualLogMapper hdfcVirtualLogMapper;

    @Override
    public PaginatedResponse<HdfcVirtualLogResponse> fetchHdfcVirtualLog(HdfcVirtualLogRequest request) {

        PageRequest page = Utility.pageRequest(request.getPageNo(), request.getPageSize(), request.getSortBy(),
                request.getOrderBy());

        Page<HdfcVirtualLogEntity> paginatedContent = hdfcVirtualLogRepository.fetchHdfcVirtualLog(request.getStartDate(),
                request.getEndDate(), request.getUserId(), request.getUserName(), request.getAccountNumber(),
                request.getStatus(), request.getSearch(), request.getSearchByField(), page);

        List<HdfcVirtualLogResponse> response = new ArrayList<>();
        paginatedContent.getContent().forEach(content ->
                response.add(hdfcVirtualLogMapper.toResponse(content)));

        return Utility.paginatedResponseForSubList(paginatedContent.getNumber(), paginatedContent.getTotalPages(),
                paginatedContent.getSize(), paginatedContent.getNumberOfElements(), paginatedContent.getTotalElements(),
                response);
    }
}
