package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.Aeps2AadharPayCommissionRequestDTO;
import com.toshaniFintech.user_service.dto.request.Aeps3AadharPayCommissionGetAll;
import com.toshaniFintech.user_service.dto.request.Aeps3AadharPayCommissionRequestDTO;
import com.toshaniFintech.user_service.dto.response.Aeps2AadharPayCommissionResponseDTO;
import com.toshaniFintech.user_service.dto.response.Aeps3AadharPayCommissionResponseDTO;
import com.toshaniFintech.user_service.entity.Aeps2AadharPayCommissionEntity;
import com.toshaniFintech.user_service.entity.Aeps3AadharPayCommissionEntity;
import com.toshaniFintech.user_service.mapper.Aeps2AadharPayCommissionMapper;
import com.toshaniFintech.user_service.mapper.Aeps3AadharPayCommissionMapper;
import com.toshaniFintech.user_service.model.Aeps2AadharPayCommissionModel;
import com.toshaniFintech.user_service.model.Aeps3AadharPayCommissionModel;
import com.toshaniFintech.user_service.repository.Aeps2AadharPayCommissionRepository;
import com.toshaniFintech.user_service.repository.Aeps3AadharPayCommissionRepository;
import com.toshaniFintech.user_service.service.Aeps2AadharPayCommissionService;
import com.toshaniFintech.user_service.service.Aeps3AadharPayCommissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Aeps3AadharPayCommissionImpl implements Aeps3AadharPayCommissionService {

    @Autowired
    private Aeps3AadharPayCommissionRepository aeps3AadharPayCommissionRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private Aeps3AadharPayCommissionMapper aeps3AadharPayCommissionMapper;

    @Override
    public Aeps3AadharPayCommissionModel createAeps3AadharPay(
            Aeps3AadharPayCommissionModel aeps3AadharPayCommissionModel) {

        Aeps3AadharPayCommissionEntity aeps3AadharPayCommissionEntity = objectMapper.convertValue
                (aeps3AadharPayCommissionModel, Aeps3AadharPayCommissionEntity.class);

        Aeps3AadharPayCommissionEntity saved =
                aeps3AadharPayCommissionRepository.save(aeps3AadharPayCommissionEntity);

        return objectMapper.convertValue(saved, Aeps3AadharPayCommissionModel.class);
    }

    @Override
    public PaginatedResponse<Aeps3AadharPayCommissionResponseDTO> getAllAeps3AadharPay(
            Aeps3AadharPayCommissionGetAll aeps3AadharPayCommissionGetAll) {

        PageRequest page = Utility.pageRequest(
                aeps3AadharPayCommissionGetAll.getPageNo(),
                aeps3AadharPayCommissionGetAll.getPageSize(),
                aeps3AadharPayCommissionGetAll.getSortBy(),
                aeps3AadharPayCommissionGetAll.getOrderBy());

        Page<Aeps3AadharPayCommissionEntity> paginatedContent =
                aeps3AadharPayCommissionRepository.fetchAllAeps3AadharPay(
                        aeps3AadharPayCommissionGetAll.getChargeType(),
                        aeps3AadharPayCommissionGetAll.getStartDate(),
                        aeps3AadharPayCommissionGetAll.getEndDate(),
                        aeps3AadharPayCommissionGetAll.getSearch(),
                        aeps3AadharPayCommissionGetAll.getSearchByField(),
                        page);

        List<Aeps3AadharPayCommissionResponseDTO> responseDTOS = new ArrayList<>();
        paginatedContent.getContent().forEach(content ->
                responseDTOS.add(aeps3AadharPayCommissionMapper.toResponseDto(content)));

        return Utility.paginatedResponseForSubList(
                paginatedContent.getNumber(),
                paginatedContent.getTotalPages(),
                paginatedContent.getSize(),
                paginatedContent.getNumberOfElements(),
                paginatedContent.getTotalElements(),
                responseDTOS);
    }

    @Override
    public Aeps3AadharPayCommissionResponseDTO getByIdAeps3AadharPay(String id) {

        Aeps3AadharPayCommissionEntity aeps3AadharPayCommissionEntity =
                aeps3AadharPayCommissionRepository.findById(id).
                        orElseThrow(() -> new RuntimeException("Aeps3 Aadhar Pay not found with id: " + id));

        return aeps3AadharPayCommissionMapper.toResponseDto(aeps3AadharPayCommissionEntity);
    }

    @Override
    public Aeps3AadharPayCommissionResponseDTO updateAeps3AadharPay(
            String id, Aeps3AadharPayCommissionModel aeps3AadharPayCommissionModel) {

        Aeps3AadharPayCommissionEntity aeps3AadharPayCommissionEntity =
                aeps3AadharPayCommissionRepository.findById(id).
                        orElseThrow(() -> new RuntimeException("Aeps3 Aadhar Pay not found with id: " + id));

        aeps3AadharPayCommissionEntity.setMinAmount(aeps3AadharPayCommissionModel.getMinAmount());
        aeps3AadharPayCommissionEntity.setMaxAmount(aeps3AadharPayCommissionModel.getMaxAmount());
        aeps3AadharPayCommissionEntity.setChargeType(aeps3AadharPayCommissionModel.getChargeType());
        aeps3AadharPayCommissionEntity.setCharge(aeps3AadharPayCommissionModel.getCharge());

        Aeps3AadharPayCommissionEntity updatedEntity =
                aeps3AadharPayCommissionRepository.save(aeps3AadharPayCommissionEntity);

        return aeps3AadharPayCommissionMapper.toResponseDto(updatedEntity);
    }

    @Override
    public void deleteAeps3AadharPay(String id) {

        Aeps3AadharPayCommissionEntity aeps3AadharPayCommissionEntity =
                aeps3AadharPayCommissionRepository.findById(id).
                        orElseThrow(() -> new RuntimeException("Aeps3 Aadhar Pay not found with id: " + id));

        aeps3AadharPayCommissionRepository.delete(aeps3AadharPayCommissionEntity);
    }
}
