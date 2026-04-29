package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.PartnerMasterRequest;
import com.toshaniFintech.user_service.dto.response.PartnerMasterResponse;
import com.toshaniFintech.user_service.entity.PartnerMasterEntity;
import com.toshaniFintech.user_service.mapper.PartnerMasterMapper;
import com.toshaniFintech.user_service.repository.PartnerMasterRepository;
import com.toshaniFintech.user_service.service.PartnerMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartnerMasterServiceImpl implements PartnerMasterService {

    @Autowired
    private PartnerMasterRepository repository;

    @Autowired
    private PartnerMasterMapper mapper;

    @Override
    public PaginatedResponse<PartnerMasterResponse> fetchPartners(PartnerMasterRequest request) {

        PageRequest page = Utility.pageRequest(
                request.getPageNo(),
                request.getPageSize(),
                request.getSortBy(),
                request.getOrderBy()
        );

        Page<PartnerMasterEntity> data = repository.fetchPartners(
                request.getPartnerType(),
                request.getPartnerName(),
                request.getPartnerStatus(),
                request.getSearch(),
                request.getSearchByField(),
                page
        );

        List<PartnerMasterResponse> list = data.getContent()
                .stream()
                .map(mapper::toResponseDto)
                .toList();

        return Utility.paginatedResponseForSubList(
                data.getNumber(),
                data.getTotalPages(),
                data.getSize(),
                data.getNumberOfElements(),
                data.getTotalElements(),
                list
        );
    }
}
