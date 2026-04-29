package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.Aeps1AadharPayCommissionRequestDTO;
import com.toshaniFintech.user_service.dto.response.Aeps1AadharPayCommissionResponseDTO;
import com.toshaniFintech.user_service.entity.Aeps1AadharPayCommissionEntity;
import com.toshaniFintech.user_service.mapper.Aeps1AadharPayCommissionMapper;
import com.toshaniFintech.user_service.model.Aeps1AadharPayCommissionModel;
import com.toshaniFintech.user_service.repository.Aeps1AadharPayCommissionRepository;
import com.toshaniFintech.user_service.service.Aeps1AadharPayCommissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Aeps1AadharPayCommissionImpl implements Aeps1AadharPayCommissionService {

    @Autowired
    private Aeps1AadharPayCommissionRepository aeps1AadharPayCommissionRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private Aeps1AadharPayCommissionMapper aeps1AadharPayCommissionMapper;


    @Override
    public Aeps1AadharPayCommissionModel create(Aeps1AadharPayCommissionModel aeps1AadharPayCommissionModel) {

        Aeps1AadharPayCommissionEntity aeps1AadharPayCommissionEntity = objectMapper.convertValue
                (aeps1AadharPayCommissionModel, Aeps1AadharPayCommissionEntity.class);

        Aeps1AadharPayCommissionEntity saved =
                aeps1AadharPayCommissionRepository.save(aeps1AadharPayCommissionEntity);

        return objectMapper.convertValue(saved, Aeps1AadharPayCommissionModel.class);
    }

    @Override
    public PaginatedResponse<Aeps1AadharPayCommissionResponseDTO> getAll(
            Aeps1AadharPayCommissionRequestDTO aeps1AadharPayCommissionRequestDTO) {

        PageRequest page = Utility.pageRequest(
                aeps1AadharPayCommissionRequestDTO.getPageNo(),
                aeps1AadharPayCommissionRequestDTO.getPageSize(),
                aeps1AadharPayCommissionRequestDTO.getSortBy(),
                aeps1AadharPayCommissionRequestDTO.getOrderBy());

        Page<Aeps1AadharPayCommissionEntity> paginatedContent = aeps1AadharPayCommissionRepository.fetchAll(
                aeps1AadharPayCommissionRequestDTO.getChargeType(),
                aeps1AadharPayCommissionRequestDTO.getSearch(),
                aeps1AadharPayCommissionRequestDTO.getSearchByField(),
                page);

        List<Aeps1AadharPayCommissionResponseDTO> responseDTOS = new ArrayList<>();
        paginatedContent.getContent().forEach(content ->
                responseDTOS.add(aeps1AadharPayCommissionMapper.toResponseDto(content)));

        return Utility.paginatedResponseForSubList(
                paginatedContent.getNumber(),
                paginatedContent.getTotalPages(),
                paginatedContent.getSize(),
                paginatedContent.getNumberOfElements(),
                paginatedContent.getTotalElements(),
                responseDTOS);
    }

    @Override
    public Aeps1AadharPayCommissionResponseDTO getById(String id) {

        Aeps1AadharPayCommissionEntity aeps1AadharPayCommissionEntity =
                aeps1AadharPayCommissionRepository.findById(id).
                        orElseThrow(() -> new RuntimeException("Aeps1 Aadhar Pay not found with id: " + id));

        return aeps1AadharPayCommissionMapper.toResponseDto(aeps1AadharPayCommissionEntity);
    }


    @Override
    public Aeps1AadharPayCommissionResponseDTO update(
            String id, Aeps1AadharPayCommissionModel aeps1AadharPayCommissionModel) {

        Aeps1AadharPayCommissionEntity aeps1AadharPayCommissionEntity =
                aeps1AadharPayCommissionRepository.findById(id).
                        orElseThrow(() -> new RuntimeException("Aeps1 Aadhar Pay not found with id: " + id));

        aeps1AadharPayCommissionEntity.setMinAmount(aeps1AadharPayCommissionModel.getMinAmount());
        aeps1AadharPayCommissionEntity.setMaxAmount(aeps1AadharPayCommissionModel.getMaxAmount());
        aeps1AadharPayCommissionEntity.setChargeType(aeps1AadharPayCommissionModel.getChargeType());
        aeps1AadharPayCommissionEntity.setCharge(aeps1AadharPayCommissionModel.getCharge());

        Aeps1AadharPayCommissionEntity updatedEntity =
                aeps1AadharPayCommissionRepository.save(aeps1AadharPayCommissionEntity);

        return aeps1AadharPayCommissionMapper.toResponseDto(updatedEntity);
    }

    @Override
    public void delete(String id) {

        Aeps1AadharPayCommissionEntity aeps1AadharPayCommissionEntity =
                aeps1AadharPayCommissionRepository.findById(id).
                        orElseThrow(() -> new RuntimeException("Aeps1 Aadhar Pay not found with id: " + id));

        aeps1AadharPayCommissionRepository.delete(aeps1AadharPayCommissionEntity);
    }
}
