package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.Aeps2CommissionRequestDTO;
import com.toshaniFintech.user_service.dto.response.Aeps2CommissionResponseDTO;
import com.toshaniFintech.user_service.entity.Aeps2CommissionEntity;
import com.toshaniFintech.user_service.mapper.Aeps2CommissionMapper;
import com.toshaniFintech.user_service.model.Aeps2CommissionModel;
import com.toshaniFintech.user_service.repository.Aeps2CommissionRepository;
import com.toshaniFintech.user_service.service.Aeps2CommissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Aeps2CommissionImpl implements Aeps2CommissionService {

    @Autowired
    private Aeps2CommissionRepository aeps2CommissionRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private Aeps2CommissionMapper aeps2CommissionMapper;


    @Override
    public Aeps2CommissionModel create(Aeps2CommissionModel aeps2CommissionModel) {

        Aeps2CommissionEntity aeps2CommissionEntity = objectMapper.convertValue
                (aeps2CommissionModel, Aeps2CommissionEntity.class);

        Aeps2CommissionEntity saved = aeps2CommissionRepository.save(aeps2CommissionEntity);

        return objectMapper.convertValue(saved, Aeps2CommissionModel.class);
    }

    @Override
    public PaginatedResponse<Aeps2CommissionResponseDTO> getAll(
            Aeps2CommissionRequestDTO aeps2CommissionRequestDTO) {

        PageRequest page = Utility.pageRequest(
                aeps2CommissionRequestDTO.getPageNo(),
                aeps2CommissionRequestDTO.getPageSize(),
                aeps2CommissionRequestDTO.getSortBy(),
                aeps2CommissionRequestDTO.getOrderBy());

        Page<Aeps2CommissionEntity> paginatedContent = aeps2CommissionRepository.fetchAll(
                aeps2CommissionRequestDTO.getCommType(),
                aeps2CommissionRequestDTO.getTransactionType(),
                aeps2CommissionRequestDTO.getSearch(),
                aeps2CommissionRequestDTO.getSearchByField(),
                page);

        List<Aeps2CommissionResponseDTO> responseDTOS = new ArrayList<>();
        paginatedContent.getContent().forEach(content ->
                responseDTOS.add(aeps2CommissionMapper.toResponseDto(content)));

        return Utility.paginatedResponseForSubList(
                paginatedContent.getNumber(),
                paginatedContent.getTotalPages(),
                paginatedContent.getSize(),
                paginatedContent.getNumberOfElements(),
                paginatedContent.getTotalElements(),
                responseDTOS);
    }

    @Override
    public Aeps2CommissionResponseDTO getById(String id) {

        Aeps2CommissionEntity aeps2CommissionEntity =
                aeps2CommissionRepository.findById(id).
                        orElseThrow(() -> new RuntimeException("Aeps2 not found with id: " + id));

        return aeps2CommissionMapper.toResponseDto(aeps2CommissionEntity);
    }


    @Override
    public Aeps2CommissionResponseDTO update(String id, Aeps2CommissionModel aeps2CommissionModel) {

        Aeps2CommissionEntity aeps2CommissionEntity =
                aeps2CommissionRepository.findById(id).
                        orElseThrow(() -> new RuntimeException("Aeps2 not found with id: " + id));

        aeps2CommissionEntity.setMinAmount(aeps2CommissionModel.getMinAmount());
        aeps2CommissionEntity.setMaxAmount(aeps2CommissionModel.getMaxAmount());
        aeps2CommissionEntity.setCommType(aeps2CommissionModel.getCommType());
        aeps2CommissionEntity.setCommission(aeps2CommissionModel.getCommission());
        aeps2CommissionEntity.setTransactionType(aeps2CommissionModel.getTransactionType());

        Aeps2CommissionEntity updatedEntity = aeps2CommissionRepository.save(aeps2CommissionEntity);

        return aeps2CommissionMapper.toResponseDto(updatedEntity);
    }

    @Override
    public void delete(String id) {

        Aeps2CommissionEntity aeps2CommissionEntity =
                aeps2CommissionRepository.findById(id).
                        orElseThrow(() -> new RuntimeException("Aeps2 not found with id: " + id));

        aeps2CommissionRepository.delete(aeps2CommissionEntity);
    }
}
