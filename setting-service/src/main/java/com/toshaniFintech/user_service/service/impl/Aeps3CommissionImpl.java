package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.Aeps3CommissionGetAll;
import com.toshaniFintech.user_service.dto.request.Aeps3CommissionRequestDTO;
import com.toshaniFintech.user_service.dto.response.Aeps3CommissionResponseDTO;
import com.toshaniFintech.user_service.entity.Aeps3CommissionEntity;
import com.toshaniFintech.user_service.mapper.Aeps3CommissionMapper;
import com.toshaniFintech.user_service.model.Aeps3CommissionModel;
import com.toshaniFintech.user_service.repository.Aeps3CommissionRepository;
import com.toshaniFintech.user_service.service.Aeps3CommissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Aeps3CommissionImpl implements Aeps3CommissionService {
    @Autowired
    private Aeps3CommissionRepository aeps3CommissionRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private Aeps3CommissionMapper aeps3CommissionMapper;

    @Override
    public Aeps3CommissionModel createAeps3(Aeps3CommissionModel aeps3CommissionModel) {

        Aeps3CommissionEntity aeps3CommissionEntity = objectMapper.convertValue
                (aeps3CommissionModel, Aeps3CommissionEntity.class);

        Aeps3CommissionEntity saved = aeps3CommissionRepository.save(aeps3CommissionEntity);

        return objectMapper.convertValue(saved, Aeps3CommissionModel.class);
    }

    @Override
    public PaginatedResponse<Aeps3CommissionResponseDTO> getAllAeps3(
            Aeps3CommissionGetAll aeps3CommissionRGetAll) {

        PageRequest page = Utility.pageRequest(
                aeps3CommissionRGetAll.getPageNo(),
                aeps3CommissionRGetAll.getPageSize(),
                aeps3CommissionRGetAll.getSortBy(),
                aeps3CommissionRGetAll.getOrderBy());

        Page<Aeps3CommissionEntity> paginatedContent = aeps3CommissionRepository.fetchAllAeps3(
                aeps3CommissionRGetAll.getTransactionType(),
                aeps3CommissionRGetAll.getCommissionType(),
                aeps3CommissionRGetAll.getStartDate(),
                aeps3CommissionRGetAll.getEndDate(),
                aeps3CommissionRGetAll.getSearch(),
                aeps3CommissionRGetAll.getSearchByField(),
                page);

        List<Aeps3CommissionResponseDTO> responseDTOS = new ArrayList<>();
        paginatedContent.getContent().forEach(content ->
                responseDTOS.add(aeps3CommissionMapper.toResponseDto(content)));

        return Utility.paginatedResponseForSubList(
                paginatedContent.getNumber(),
                paginatedContent.getTotalPages(),
                paginatedContent.getSize(),
                paginatedContent.getNumberOfElements(),
                paginatedContent.getTotalElements(),
                responseDTOS);
    }

    @Override
    public Aeps3CommissionResponseDTO getByIdAeps3(String id) {

        Aeps3CommissionEntity aeps3CommissionEntity =
                aeps3CommissionRepository.findById(id).
                        orElseThrow(() -> new RuntimeException("Aeps3 not found with id: " + id));

        return aeps3CommissionMapper.toResponseDto(aeps3CommissionEntity);
    }

    @Override
    public Aeps3CommissionResponseDTO updateAeps3(String id, Aeps3CommissionModel aeps3CommissionModel) {

        Aeps3CommissionEntity aeps3CommissionEntity =
                aeps3CommissionRepository.findById(id).
                        orElseThrow(() -> new RuntimeException("Aeps3 not found with id: " + id));

        aeps3CommissionEntity.setMinAmount(aeps3CommissionModel.getMinAmount());
        aeps3CommissionEntity.setMaxAmount(aeps3CommissionModel.getMaxAmount());
        aeps3CommissionEntity.setTransactionType(aeps3CommissionModel.getTransactionType());
        aeps3CommissionEntity.setCommissionType(aeps3CommissionModel.getCommissionType());
        aeps3CommissionEntity.setCommission(aeps3CommissionModel.getCommission());

        Aeps3CommissionEntity updatedEntity = aeps3CommissionRepository.save(aeps3CommissionEntity);

        return aeps3CommissionMapper.toResponseDto(updatedEntity);
    }

    @Override
    public void deleteAeps3(String id) {

        Aeps3CommissionEntity aeps3CommissionEntity =
                aeps3CommissionRepository.findById(id).
                        orElseThrow(() -> new RuntimeException("Aeps3 not found with id: " + id));

        aeps3CommissionRepository.delete(aeps3CommissionEntity);
    }
}
