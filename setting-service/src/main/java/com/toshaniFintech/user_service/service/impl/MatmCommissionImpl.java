package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.MatmCommissionGetAll;
import com.toshaniFintech.user_service.dto.request.MatmCommissionRequestDTO;
import com.toshaniFintech.user_service.dto.response.MatmCommissionResponseDTO;
import com.toshaniFintech.user_service.entity.MatmCommissionEntity;
import com.toshaniFintech.user_service.mapper.MatmCommissionMapper;
import com.toshaniFintech.user_service.model.MatmCommissionModel;
import com.toshaniFintech.user_service.repository.MatmCommissionRepository;
import com.toshaniFintech.user_service.service.MatmCommissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class MatmCommissionImpl implements MatmCommissionService {

    @Autowired
    private MatmCommissionRepository matmCommissionRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
   private MatmCommissionMapper matmCommissionMapper;


    @Override
    public MatmCommissionModel create(MatmCommissionModel matmCommissionModel) {

        MatmCommissionEntity matmCommissionEntity =
                objectMapper.convertValue(matmCommissionModel, MatmCommissionEntity.class);

        MatmCommissionEntity saved = matmCommissionRepository.save(matmCommissionEntity);

        return objectMapper.convertValue(saved, MatmCommissionModel.class);
    }
    @Override
    public PaginatedResponse<MatmCommissionResponseDTO> getAll(
            MatmCommissionGetAll matmCommissionGetAll) {

        PageRequest page = Utility.pageRequest(
                matmCommissionGetAll.getPageNo(),
                matmCommissionGetAll.getPageSize(),
                matmCommissionGetAll.getSortBy(),
                matmCommissionGetAll.getOrderBy()
        );

        Page<MatmCommissionEntity> paginatedContent =
                matmCommissionRepository.fetchAll(
                        matmCommissionGetAll.getCommType(),
                        matmCommissionGetAll.getStartDate(),
                        matmCommissionGetAll.getEndDate(),
                        matmCommissionGetAll.getSearch(),
                        matmCommissionGetAll.getSearchByField(),
                        page
                );

        List<MatmCommissionResponseDTO> responseDTOS = new ArrayList<>();
        paginatedContent.getContent().forEach(content ->
                responseDTOS.add(matmCommissionMapper.toResponseDto(content))
        );

        return Utility.paginatedResponseForSubList(
                paginatedContent.getNumber(),
                paginatedContent.getTotalPages(),
                paginatedContent.getSize(),
                paginatedContent.getNumberOfElements(),
                paginatedContent.getTotalElements(),
                responseDTOS
        );
    }

    @Override
    public MatmCommissionResponseDTO getById(String id) {

        MatmCommissionEntity matmCommissionEntity = matmCommissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matm not found with id: " + id));

        return matmCommissionMapper.toResponseDto(matmCommissionEntity);
    }


    @Override
    public MatmCommissionResponseDTO update(String id, MatmCommissionModel matmCommissionModel) {

        MatmCommissionEntity matmCommissionEntity = matmCommissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matm not found with id: " + id));

        matmCommissionEntity.setMinAmount(matmCommissionModel.getMinAmount());
        matmCommissionEntity.setMaxAmount(matmCommissionModel.getMaxAmount());
        matmCommissionEntity.setCommType(matmCommissionModel.getCommType());
        matmCommissionEntity.setComm(matmCommissionModel.getComm());

        MatmCommissionEntity updatedEntity = matmCommissionRepository.save(matmCommissionEntity);

        return matmCommissionMapper.toResponseDto(updatedEntity);
    }

    @Override
    public void delete(String id) {

        MatmCommissionEntity matmCommissionEntity = matmCommissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matm not found with id: " + id));

        matmCommissionRepository.delete(matmCommissionEntity);
    }
}
