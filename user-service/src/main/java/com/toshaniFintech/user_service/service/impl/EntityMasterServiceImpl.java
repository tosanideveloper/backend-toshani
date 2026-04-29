package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.EntityMasterCreateRequest;
import com.toshaniFintech.user_service.dto.request.EntityMasterFetchRequest;
import com.toshaniFintech.user_service.dto.response.EntityMasterResponse;
import com.toshaniFintech.user_service.entity.ChannelMasterEntity;
import com.toshaniFintech.user_service.entity.ClientMasterEntity;
import com.toshaniFintech.user_service.entity.EntityMasterEntity;
import com.toshaniFintech.user_service.entity.HierarchyMasterEntity;
import com.toshaniFintech.user_service.entity.PartnerMasterEntity;
import com.toshaniFintech.user_service.mapper.EntityMasterMapper;
import com.toshaniFintech.user_service.repository.ChannelMasterRepository;
import com.toshaniFintech.user_service.repository.ClientMasterRepository;
import com.toshaniFintech.user_service.repository.EntityMasterRepository;
import com.toshaniFintech.user_service.repository.HierarchyMasterRepository;
import com.toshaniFintech.user_service.repository.PartnerMasterRepository;
import com.toshaniFintech.user_service.service.EntityMasterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class EntityMasterServiceImpl implements EntityMasterService {

    @Autowired
    private EntityMasterRepository repository;

    @Autowired
    private ClientMasterRepository clientRepo;

    @Autowired
    private PartnerMasterRepository partnerRepo;

    @Autowired
    private ChannelMasterRepository channelRepo;

    @Autowired
    private HierarchyMasterRepository hierarchyRepo;

    @Autowired
    private EntityMasterMapper mapper;

    @Override
    public EntityMasterResponse create(EntityMasterCreateRequest request) {

        EntityMasterEntity entity = new EntityMasterEntity();
        entity.setEntityUuid(UUID.randomUUID().toString());
        entity.setEntityName(request.getEntityName());

        return mapper.toDto(repository.save(entity));
    }

    @Override
    public EntityMasterResponse update(String uuid, EntityMasterCreateRequest request) {

        EntityMasterEntity entity = repository.findByEntityUuid(uuid)
                .orElseThrow(() -> new RuntimeException("Entity not found"));

        entity.setEntityName(request.getEntityName());


        return mapper.toDto(repository.save(entity));
    }

    @Override
    public EntityMasterResponse getByUuid(String uuid) {
        return mapper.toDto(
                repository.findByEntityUuid(uuid)
                        .orElseThrow(() -> new RuntimeException("Entity not found"))
        );
    }

    @Override
    public PaginatedResponse<EntityMasterResponse> getAll(EntityMasterFetchRequest request) {

        PageRequest page = Utility.pageRequest(
                request.getPageNo(),
                request.getPageSize(),
                request.getSortBy(),
                request.getOrderBy()
        );

        Page<EntityMasterEntity> data = repository.fetchEntities(
                request.getEntityName(),
                request.getSearch(),
                request.getSearchByField(),
                page
        );

        List<EntityMasterResponse> list = data.getContent()
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
