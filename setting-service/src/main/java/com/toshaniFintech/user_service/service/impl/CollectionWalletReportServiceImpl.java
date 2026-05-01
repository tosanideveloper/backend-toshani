package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.CollectionWalletReportRequest;
import com.toshaniFintech.user_service.dto.response.CollectionWalletReportResponse;
import com.toshaniFintech.user_service.entity.CollectionWalletReportEntity;
import com.toshaniFintech.user_service.mapper.CollectionWalletReportMapper;
import com.toshaniFintech.user_service.repository.CollectionWalletReportRepository;
import com.toshaniFintech.user_service.service.CollectionWalletReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CollectionWalletReportServiceImpl implements CollectionWalletReportService {
    @Autowired
    private CollectionWalletReportRepository collectionWalletReportRepository;

    @Autowired
    private CollectionWalletReportMapper collectionWalletReportMapper;

    @Override
    public PaginatedResponse<CollectionWalletReportResponse> fetchCollectionWalletReport
            (CollectionWalletReportRequest request) {

        PageRequest page = Utility.pageRequest(request.getPageNo(), request.getPageSize(), request.getSortBy(),
                request.getOrderBy());

        Page<CollectionWalletReportEntity>
                paginatedContent = collectionWalletReportRepository.fetchCollectionWalletReport(request.getStartDate(),
                request.getEndDate(),request.getTxnId(),
                request.getSearch(), request.getSearchByField(), page);

        List<CollectionWalletReportResponse> response = new ArrayList<>();
        paginatedContent.getContent().forEach(content ->
                response.add(collectionWalletReportMapper.toResponse(content)));

        return Utility.paginatedResponseForSubList(paginatedContent.getNumber(), paginatedContent.getTotalPages(),
                paginatedContent.getSize(), paginatedContent.getNumberOfElements(), paginatedContent.getTotalElements(),
                response);
    }
}
