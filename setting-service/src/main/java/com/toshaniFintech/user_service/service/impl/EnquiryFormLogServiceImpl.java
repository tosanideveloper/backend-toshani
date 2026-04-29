package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.EnquiryFormLogRequest;
import com.toshaniFintech.user_service.dto.response.EnquiryFormLogResponse;
import com.toshaniFintech.user_service.entity.EnquiryFormLogEntity;
import com.toshaniFintech.user_service.mapper.EnquiryFormLogMapper;
import com.toshaniFintech.user_service.repository.EnquiryFormLogRepository;
import com.toshaniFintech.user_service.service.EnquiryFormLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EnquiryFormLogServiceImpl implements EnquiryFormLogService {
    @Autowired
    private EnquiryFormLogRepository enquiryFormLogRepository;
    @Autowired
    private EnquiryFormLogMapper enquiryFormLogMapper;

    @Override
    public PaginatedResponse<EnquiryFormLogResponse> fetchEnquiryFormLog(EnquiryFormLogRequest request) {

        PageRequest page = Utility.pageRequest(request.getPageNo(), request.getPageSize(), request.getSortBy(),
                request.getOrderBy());

        Page<EnquiryFormLogEntity> paginatedContent = enquiryFormLogRepository.fetchEnquiryFormLog(request.getStartDate(),
                request.getEndDate(), request.getSearch(), request.getSearchByField(), page);

        List<EnquiryFormLogResponse> response = new ArrayList<>();
        paginatedContent.getContent().forEach(content ->
                response.add(enquiryFormLogMapper.toResponse(content)));

        return Utility.paginatedResponseForSubList(paginatedContent.getNumber(), paginatedContent.getTotalPages(),
                paginatedContent.getSize(), paginatedContent.getNumberOfElements(), paginatedContent.getTotalElements(),
                response);
    }
}
