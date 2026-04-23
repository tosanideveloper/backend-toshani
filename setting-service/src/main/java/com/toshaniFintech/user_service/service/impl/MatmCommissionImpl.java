package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.MatmCommissionRequestDTO;
import com.toshaniFintech.user_service.dto.response.MatmCommissionResponseDTO;
import com.toshaniFintech.user_service.entity.MatmCommissionEntity;
import com.toshaniFintech.user_service.model.MatmCommissionModel;
import com.toshaniFintech.user_service.repository.MatmCommissionRepository;
import com.toshaniFintech.user_service.service.MatmCommissionService;
import org.aspectj.apache.bcel.classfile.Utility;
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

//    @Autowired
//    private MatmCommisionMapper matmCommisionMapper;

    // ✅ CREATE
    @Override
    public MatmCommissionModel create(MatmCommissionModel matmCommissionModel) {

        MatmCommissionEntity matmCommissionEntity =
                objectMapper.convertValue(matmCommissionModel, MatmCommissionEntity.class);

        MatmCommissionEntity saved = matmCommissionRepository.save(matmCommissionEntity);

        return objectMapper.convertValue(saved, MatmCommissionModel.class);
    }
    // ✅ GET ALL (Pagination + Filter)
    @Override
    public PaginatedResponse<MatmCommissionResponseDTO> getAll(
            MatmCommissionRequestDTO matmCommissionRequestDTO) {

        PageRequest page = Utility.pageRequest(
                matmCommissionRequestDTO.getPageNo(),
                matmCommissionRequestDTO.getPageSize(),
                matmCommissionRequestDTO.getSortBy(),
                matmCommissionRequestDTO.getOrderBy()
        );

        Page<MatmCommissionEntity> paginatedContent =
                matmCommissionRepository.fetchAll(
                        matmCommissionRequestDTO.getMinAmount(),
                        matmCommissionRequestDTO.getMaxAmount(),
                        matmCommissionRequestDTO.getCommtype(),
                        matmCommissionRequestDTO.getSearch(),
                        matmCommissionRequestDTO.getSearchByField(),
                        page
                );

        List<MatmCommissionResponseDTO> responseDTOS = new ArrayList<>();
        paginatedContent.getContent().forEach(content ->
                responseDTOS.add(mapper.toResponseDto(content))
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

    // ✅ GET BY ID
    @Override
    public MatmCommissionResponseDTO getById(String id) {

        MatmCommissionEntity matmCommissionEntity = matmCommissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matm not found with id: " + id));

        return mapper.toResponseDto(matmCommissionEntity);
    }

    // ✅ UPDATE
    @Override
    public MatmCommissionResponseDTO update(String id, MatmCommissionModel matmCommissionModel) {

        MatmCommissionEntity matmCommissionEntity = matmCommissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matm not found with id: " + id));

        matmCommissionEntity.setMinAmount(matmCommissionModel.getMinAmount());
        matmCommissionEntity.setMaxAmount(matmCommissionModel.getMaxAmount());
        matmCommissionEntity.setCommType(matmCommissionModel.getCommType());
        matmCommissionEntity.setComm(matmCommissionModel.getComm());

        MatmCommissionEntity updatedEntity = matmCommissionRepository.save(matmCommissionEntity);

        return mapper.toResponseDto(updatedEntity);
    }

    // ✅ DELETE
    @Override
    public void delete(String id) {

        MatmCommissionEntity matmCommissionEntity = matmCommissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matm not found with id: " + id));

        matmCommissionRepository.delete(matmCommissionEntity);
    }
}
