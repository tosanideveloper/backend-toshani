package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.UpiLiteChargeRequestDTO;
import com.toshaniFintech.user_service.dto.response.UpiLiteChargeResponseDTO;
import com.toshaniFintech.user_service.entity.UpiLiteChargeEntity;
import com.toshaniFintech.user_service.mapper.UpiLiteChargeMapper;
import com.toshaniFintech.user_service.model.UpiLiteChargeModel;
import com.toshaniFintech.user_service.repository.UpiLiteChargeRepository;
import com.toshaniFintech.user_service.service.UpiLiteChargeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UpiLiteChargeServiceImpl implements UpiLiteChargeService {

    @Autowired
    private UpiLiteChargeRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UpiLiteChargeMapper mapper;

    @Override
    public UpiLiteChargeModel create(UpiLiteChargeModel model) {

        UpiLiteChargeEntity entity =
                objectMapper.convertValue(model, UpiLiteChargeEntity.class);

        return objectMapper.convertValue(repository.save(entity), UpiLiteChargeModel.class);
    }

    @Override
    public PaginatedResponse<UpiLiteChargeResponseDTO> getAll(UpiLiteChargeRequestDTO dto) {

        PageRequest page = Utility.pageRequest(
                dto.getPageNo(),
                dto.getPageSize(),
                dto.getSortBy(),
                dto.getOrderBy()
        );

        Page<UpiLiteChargeEntity> data =
                repository.fetchAll(
                        dto.getMinAmount(),
                        dto.getMaxAmount(),
                        dto.getChargeType(),
                        dto.getSearch(),
                        dto.getSearchByField(),
                        page
                );

        List<UpiLiteChargeResponseDTO> list = new ArrayList<>();
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
    public UpiLiteChargeResponseDTO getById(String id) {

        UpiLiteChargeEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Charge not found"));

        return mapper.toResponseDto(entity);
    }

    @Override
    public UpiLiteChargeResponseDTO update(String id, UpiLiteChargeModel model) {

        UpiLiteChargeEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Charge not found"));

        entity.setMinAmount(model.getMinAmount());
        entity.setMaxAmount(model.getMaxAmount());
        entity.setChargeType(model.getChargeType());
        entity.setCharge(model.getCharge());

        return mapper.toResponseDto(repository.save(entity));
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}