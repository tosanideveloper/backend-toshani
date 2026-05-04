package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.Aeps2MerchantReportRequest;
import com.toshaniFintech.user_service.dto.response.Aeps2MerchantReportResponse;
import com.toshaniFintech.user_service.entity.Aeps2MerchantReportEntity;
import com.toshaniFintech.user_service.mapper.Aeps2MerchantReportMapper;
import com.toshaniFintech.user_service.repository.Aeps2MerchantReportRepository;
import com.toshaniFintech.user_service.service.Aeps2MerchantReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Aeps2MerchantReportServiceImpl implements Aeps2MerchantReportService {
    @Autowired
    private Aeps2MerchantReportRepository aeps2MerchantReportRepository;
    @Autowired
    private Aeps2MerchantReportMapper aeps2MerchantReportMapper;

    @Override
    public PaginatedResponse<Aeps2MerchantReportResponse> fetchAeps2MerchantReport
            (Aeps2MerchantReportRequest request) {

        PageRequest page = Utility.pageRequest(request.getPageNo(), request.getPageSize(), request.getSortBy(),
                request.getOrderBy());

        Page<Aeps2MerchantReportEntity> paginatedContent = aeps2MerchantReportRepository.fetchAeps2MerchantReport
                (request.getStartDate(), request.getEndDate(), request.getSearch(), request.getSearchByField(), page);

        List<Aeps2MerchantReportResponse> response = new ArrayList<>();
        paginatedContent.getContent().forEach(content ->
                response.add(aeps2MerchantReportMapper.toResponse(content)));

        return Utility.paginatedResponseForSubList(paginatedContent.getNumber(), paginatedContent.getTotalPages(),
                paginatedContent.getSize(), paginatedContent.getNumberOfElements(), paginatedContent.getTotalElements(),
                response);
    }

}
