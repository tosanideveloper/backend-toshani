package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.UpiExpressAccountRequestDTO;
import com.toshaniFintech.user_service.dto.response.UpiExpressAccountResponseDTO;
import com.toshaniFintech.user_service.entity.UpiExpressAccountEntity;
import com.toshaniFintech.user_service.mapper.UpiExpressAccountMapper;
import com.toshaniFintech.user_service.model.UpiExpressAccountModel;
import com.toshaniFintech.user_service.repository.UpiExpressAccountRepository;
import com.toshaniFintech.user_service.service.UpiExpressAccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UpiExpressAccountServiceImpl implements UpiExpressAccountService {

    @Autowired
    private UpiExpressAccountRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UpiExpressAccountMapper mapper;

    @Override
    public UpiExpressAccountModel create(UpiExpressAccountModel model) {

        UpiExpressAccountEntity entity =
                objectMapper.convertValue(model, UpiExpressAccountEntity.class);

        return objectMapper.convertValue(repository.save(entity), UpiExpressAccountModel.class);
    }

    @Override
    public PaginatedResponse<UpiExpressAccountResponseDTO> getAll(
            UpiExpressAccountRequestDTO dto) {

        PageRequest page = Utility.pageRequest(
                dto.getPageNo(),
                dto.getPageSize(),
                dto.getSortBy(),
                dto.getOrderBy()
        );

        Page<UpiExpressAccountEntity> data =
                repository.fetchAll(
                        dto.getSearch(),
                        dto.getSearchByField(),
                        page
                );

        List<UpiExpressAccountResponseDTO> list = new ArrayList<>();
        data.getContent().forEach(e -> list.add(mapper.toResponseDto(e)));

        return Utility.paginatedResponseForSubList(
                data.getNumber(),
                data.getTotalPages(),
                data.getSize(),
                data.getNumberOfElements(),
                data.getTotalElements(),
                list
        );
    }

    @Override
    public UpiExpressAccountResponseDTO getById(String id) {

        UpiExpressAccountEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        return mapper.toResponseDto(entity);
    }

    @Override
    public UpiExpressAccountResponseDTO update(String id, UpiExpressAccountModel model) {

        UpiExpressAccountEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        entity.setAccountNo(model.getAccountNo());
        entity.setLimitAmount(model.getLimitAmount());
        entity.setTxnDate(model.getTxnDate());

        return mapper.toResponseDto(repository.save(entity));
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}