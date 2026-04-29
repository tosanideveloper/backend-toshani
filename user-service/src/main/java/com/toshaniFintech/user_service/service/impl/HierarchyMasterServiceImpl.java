package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.HierarchyMasterCreateRequest;
import com.toshaniFintech.user_service.dto.request.HierarchyMasterFetchRequest;
import com.toshaniFintech.user_service.dto.response.HierarchyMasterResponse;
import com.toshaniFintech.user_service.entity.ChannelMasterEntity;
import com.toshaniFintech.user_service.entity.ClientMasterEntity;
import com.toshaniFintech.user_service.entity.HierarchyMasterEntity;
import com.toshaniFintech.user_service.entity.PartnerMasterEntity;
import com.toshaniFintech.user_service.mapper.HierarchyMasterMapper;
import com.toshaniFintech.user_service.repository.ChannelMasterRepository;
import com.toshaniFintech.user_service.repository.ClientMasterRepository;
import com.toshaniFintech.user_service.repository.HierarchyMasterRepository;
import com.toshaniFintech.user_service.repository.PartnerMasterRepository;
import com.toshaniFintech.user_service.service.HierarchyMasterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class HierarchyMasterServiceImpl implements HierarchyMasterService {

    @Autowired
    private HierarchyMasterRepository repository;

    @Autowired
    private ClientMasterRepository clientRepo;

    @Autowired
    private PartnerMasterRepository partnerRepo;

    @Autowired
    private ChannelMasterRepository channelRepo;

    @Autowired
    private HierarchyMasterMapper mapper;

    @Override
    public HierarchyMasterResponse create(HierarchyMasterCreateRequest request) {


        HierarchyMasterEntity entity = new HierarchyMasterEntity();
        entity.setHirarchyUuid(UUID.randomUUID().toString());
        entity.setHirarchyName(request.getHirarchyName());
        entity.setHirarchyStatus(request.getHirarchyStatus());

        return mapper.toDto(repository.save(entity));
    }

    @Override
    public HierarchyMasterResponse update(String uuid, HierarchyMasterCreateRequest request) {

        HierarchyMasterEntity entity = repository.findByHirarchyUuid(uuid)
                .orElseThrow(() -> new RuntimeException("Hierarchy not found"));

        entity.setHirarchyName(request.getHirarchyName());
        entity.setHirarchyStatus(request.getHirarchyStatus());

        return mapper.toDto(repository.save(entity));
    }

    @Override
    public HierarchyMasterResponse getByUuid(String uuid) {
        return mapper.toDto(
                repository.findByHirarchyUuid(uuid)
                        .orElseThrow(() -> new RuntimeException("Hierarchy not found"))
        );
    }

    @Override
    public PaginatedResponse<HierarchyMasterResponse> getAll(HierarchyMasterFetchRequest request) {

        PageRequest page = Utility.pageRequest(
                request.getPageNo(),
                request.getPageSize(),
                request.getSortBy(),
                request.getOrderBy()
        );

        Page<HierarchyMasterEntity> data = repository.fetchHierarchy(
                request.getHirarchyName(),
                request.getHirarchyStatus(),
                request.getSearch(),
                request.getSearchByField(),
                page
        );

        List<HierarchyMasterResponse> list = data.getContent()
                .stream()
                .map(mapper::toDto)
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