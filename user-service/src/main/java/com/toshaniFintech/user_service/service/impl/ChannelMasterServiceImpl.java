package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.ChannelMasterFetchRequest;
import com.toshaniFintech.user_service.dto.request.ChannelMasterCreateRequest;
import com.toshaniFintech.user_service.dto.response.ChannelMasterResponse;
import com.toshaniFintech.user_service.entity.ChannelMasterEntity;
import com.toshaniFintech.user_service.mapper.ChannelMasterMapper;
import com.toshaniFintech.user_service.repository.ChannelMasterRepository;
import com.toshaniFintech.user_service.repository.ClientMasterRepository;
import com.toshaniFintech.user_service.repository.PartnerMasterRepository;
import com.toshaniFintech.user_service.service.ChannelMasterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelMasterServiceImpl implements ChannelMasterService {

    @Autowired
    private ChannelMasterRepository repository;

    @Autowired
    private ClientMasterRepository clientRepo;

    @Autowired
    private PartnerMasterRepository partnerRepo;

    @Autowired
    private ChannelMasterMapper mapper;

    @Override
    public ChannelMasterResponse create(ChannelMasterCreateRequest request) {

        ChannelMasterEntity entity = new ChannelMasterEntity();
        entity.setChannelName(request.getChannelName());
        entity.setChannelStatus(request.getChannelStatus());

        return mapper.toDto(repository.save(entity));
    }

    @Override
    public ChannelMasterResponse update(String uuid, ChannelMasterCreateRequest request) {

        ChannelMasterEntity entity = repository.findByChannelUuid(uuid)
                .orElseThrow(() -> new RuntimeException("Channel not found"));

        entity.setChannelName(request.getChannelName());
        entity.setChannelStatus(request.getChannelStatus());

        return mapper.toDto(repository.save(entity));
    }

    @Override
    public ChannelMasterResponse getByUuid(String uuid) {
        return mapper.toDto(
                repository.findByChannelUuid(uuid)
                        .orElseThrow(() -> new RuntimeException("Channel not found"))
        );
    }

    @Override
    public PaginatedResponse<ChannelMasterResponse> getAll(ChannelMasterFetchRequest request) {

        PageRequest page = Utility.pageRequest(
                request.getPageNo(),
                request.getPageSize(),
                request.getSortBy(),
                request.getOrderBy()
        );

        Page<ChannelMasterEntity> data = repository.fetchChannels(
                request.getChannelName(),
                request.getChannelStatus(),
                request.getSearch(),
                request.getSearchByField(),
                page
        );

        List<ChannelMasterResponse> list = data.getContent()
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
