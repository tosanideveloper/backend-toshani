package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.ClientMasterRequest;
import com.toshaniFintech.user_service.dto.response.ClientMasterResponse;
import com.toshaniFintech.user_service.entity.ClientMasterEntity;
import com.toshaniFintech.user_service.mapper.ClientMasterMapper;
import com.toshaniFintech.user_service.repository.ClientMasterRepository;
import com.toshaniFintech.user_service.service.ClientMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientMasterServiceImpl implements ClientMasterService  {

    @Autowired
    private ClientMasterRepository repository;

    @Autowired
    private ClientMasterMapper mapper;

    @Override
    public PaginatedResponse<ClientMasterResponse> fetchClients(ClientMasterRequest request) {

        PageRequest page = Utility.pageRequest(
                request.getPageNo(),
                request.getPageSize(),
                request.getSortBy(),
                request.getOrderBy()
        );

        Page<ClientMasterEntity> paginatedContent =
                repository.fetchClients(
                        request.getClientName(),
                        request.getClientStatus(),
                        page
                );

        List<ClientMasterResponse> responseList = new ArrayList<>();

        paginatedContent.getContent().forEach(data ->
                responseList.add(mapper.toResponseDto(data))
        );

        return Utility.paginatedResponseForSubList(
                paginatedContent.getNumber(),
                paginatedContent.getTotalPages(),
                paginatedContent.getSize(),
                paginatedContent.getNumberOfElements(),
                paginatedContent.getTotalElements(),
                responseList
        );
    }
}