package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.ExpressUpiChargeRequestDTO;
import com.toshaniFintech.user_service.dto.response.ExpressUpiChargeResponseDTO;
import com.toshaniFintech.user_service.entity.ExpressUpiChargeEntity;
import com.toshaniFintech.user_service.mapper.ExpressUpiChargeMapper;
import com.toshaniFintech.user_service.model.ExpressUpiChargeModel;
import com.toshaniFintech.user_service.repository.ExpressUpiChargeRepository;
import com.toshaniFintech.user_service.service.ExpressUpiChargeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExpressUpiChargeServiceImpl implements ExpressUpiChargeService {

    @Autowired
    private ExpressUpiChargeRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ExpressUpiChargeMapper mapper;

    @Override
    public ExpressUpiChargeModel create(ExpressUpiChargeModel model) {

        ExpressUpiChargeEntity entity =
                objectMapper.convertValue(model, ExpressUpiChargeEntity.class);

        return objectMapper.convertValue(repository.save(entity), ExpressUpiChargeModel.class);
    }

    @Override
    public PaginatedResponse<ExpressUpiChargeResponseDTO> getAll(ExpressUpiChargeRequestDTO dto) {

        PageRequest page = Utility.pageRequest(
                dto.getPageNo(),
                dto.getPageSize(),
                dto.getSortBy(),
                dto.getOrderBy()
        );

        Page<ExpressUpiChargeEntity> data =
                repository.fetchAll(
                        dto.getMinAmount(),
                        dto.getMaxAmount(),
                        dto.getChargeType(),
                        dto.getSearch(),
                        dto.getSearchByField(),
                        page
                );

        List<ExpressUpiChargeResponseDTO> list = new ArrayList<>();
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
    public ExpressUpiChargeResponseDTO getById(String id) {

        ExpressUpiChargeEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));

        return mapper.toResponseDto(entity);
    }

    @Override
    public ExpressUpiChargeResponseDTO update(String id, ExpressUpiChargeModel model) {

        ExpressUpiChargeEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));

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