package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.CardPayChargeRequestDTO;
import com.toshaniFintech.user_service.dto.response.CardPayChargeResponseDTO;
import com.toshaniFintech.user_service.entity.CardPayChargeEntity;
import com.toshaniFintech.user_service.mapper.CardPayChargeMapper;
import com.toshaniFintech.user_service.model.CardPayChargeModel;
import com.toshaniFintech.user_service.repository.CardPayChargeRepository;
import com.toshaniFintech.user_service.service.CardPayChargeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CardPayChargeServiceImpl implements CardPayChargeService {

    @Autowired
    private CardPayChargeRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CardPayChargeMapper mapper;

    @Override
    public CardPayChargeModel create(CardPayChargeModel model) {

        CardPayChargeEntity entity =
                objectMapper.convertValue(model, CardPayChargeEntity.class);

        return objectMapper.convertValue(repository.save(entity), CardPayChargeModel.class);
    }

    @Override
    public PaginatedResponse<CardPayChargeResponseDTO> getAll(CardPayChargeRequestDTO dto) {

        PageRequest page = Utility.pageRequest(
                dto.getPageNo(),
                dto.getPageSize(),
                dto.getSortBy(),
                dto.getOrderBy()
        );

        Page<CardPayChargeEntity> data =
                repository.fetchAll(
                        dto.getMinAmount(),
                        dto.getMaxAmount(),
                        dto.getChargeType(),
                        dto.getSearch(),
                        dto.getSearchByField(),
                        page
                );

        List<CardPayChargeResponseDTO> list = new ArrayList<>();
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
    public CardPayChargeResponseDTO getById(String id) {

        CardPayChargeEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Card pay Charge Not found"));

        return mapper.toResponseDto(entity);
    }

    @Override
    public CardPayChargeResponseDTO update(String id, CardPayChargeModel model) {

        CardPayChargeEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Card Pay Charge Not found"));

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