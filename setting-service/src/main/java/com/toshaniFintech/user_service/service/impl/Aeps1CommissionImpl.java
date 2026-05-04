package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.Aeps1CommissionGetAll;
import com.toshaniFintech.user_service.dto.request.Aeps1CommissionRequestDTO;
import com.toshaniFintech.user_service.dto.response.Aeps1CommissionResponseDTO;
import com.toshaniFintech.user_service.entity.Aeps1CommissionEntity;
import com.toshaniFintech.user_service.mapper.Aeps1CommissionMapper;
import com.toshaniFintech.user_service.model.Aeps1CommissionModel;
import com.toshaniFintech.user_service.repository.Aeps1CommissionRepository;
import com.toshaniFintech.user_service.service.Aeps1CommissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Aeps1CommissionImpl implements Aeps1CommissionService {

    @Autowired
    private Aeps1CommissionRepository aeps1CommissionRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private Aeps1CommissionMapper aeps1CommissionMapper;


    @Override
    public Aeps1CommissionModel create(Aeps1CommissionModel aeps1CommissionModel) {

        Aeps1CommissionEntity aeps1CommissionEntity = objectMapper.convertValue
                (aeps1CommissionModel, Aeps1CommissionEntity.class);

        Aeps1CommissionEntity saved = aeps1CommissionRepository.save(aeps1CommissionEntity);

        return objectMapper.convertValue(saved, Aeps1CommissionModel.class);
    }

    @Override
    public PaginatedResponse<Aeps1CommissionResponseDTO> getAll(
            Aeps1CommissionGetAll aeps1CommissionGetAll) {

        PageRequest page = Utility.pageRequest(
                aeps1CommissionGetAll.getPageNo(),
                aeps1CommissionGetAll.getPageSize(),
                aeps1CommissionGetAll.getSortBy(),
                aeps1CommissionGetAll.getOrderBy());

        Page<Aeps1CommissionEntity> paginatedContent = aeps1CommissionRepository.fetchAll(
                aeps1CommissionGetAll.getCommType(),
                aeps1CommissionGetAll.getStartDate(),
                aeps1CommissionGetAll.getEndDate(),
                aeps1CommissionGetAll.getSearch(),
                aeps1CommissionGetAll.getSearchByField(),
                page);

        List<Aeps1CommissionResponseDTO> responseDTOS = new ArrayList<>();
        paginatedContent.getContent().forEach(content ->
                responseDTOS.add(aeps1CommissionMapper.toResponseDto(content)));

        return Utility.paginatedResponseForSubList(
                paginatedContent.getNumber(),
                paginatedContent.getTotalPages(),
                paginatedContent.getSize(),
                paginatedContent.getNumberOfElements(),
                paginatedContent.getTotalElements(),
                responseDTOS);
    }

    @Override
    public Aeps1CommissionResponseDTO getById(String id) {

        Aeps1CommissionEntity aeps1CommissionEntity =
                aeps1CommissionRepository.findById(id).
                        orElseThrow(() -> new RuntimeException("Aeps1 not found with id: " + id));

        return aeps1CommissionMapper.toResponseDto(aeps1CommissionEntity);
    }


    @Override
    public Aeps1CommissionResponseDTO update(String id, Aeps1CommissionModel aeps1CommissionModel) {

        Aeps1CommissionEntity aeps1CommissionEntity =
                aeps1CommissionRepository.findById(id).
                        orElseThrow(() -> new RuntimeException("Aeps1 not found with id: " + id));

        aeps1CommissionEntity.setMinAmount(aeps1CommissionModel.getMinAmount());
        aeps1CommissionEntity.setMaxAmount(aeps1CommissionModel.getMaxAmount());
        aeps1CommissionEntity.setCommType(aeps1CommissionModel.getCommType());
        aeps1CommissionEntity.setCommission(aeps1CommissionModel.getCommission());

        Aeps1CommissionEntity updatedEntity = aeps1CommissionRepository.save(aeps1CommissionEntity);

        return aeps1CommissionMapper.toResponseDto(updatedEntity);
    }

    @Override
    public void delete(String id) {

        Aeps1CommissionEntity aeps1CommissionEntity =
                aeps1CommissionRepository.findById(id).
                        orElseThrow(() -> new RuntimeException("Aeps1 not found with id: " + id));

        aeps1CommissionRepository.delete(aeps1CommissionEntity);
    }
}
