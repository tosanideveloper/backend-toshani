package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.Utility;
import com.toshaniFintech.user_service.dto.request.Aeps2AadharPayCommissionRequestDTO;
import com.toshaniFintech.user_service.dto.response.Aeps2AadharPayCommissionResponseDTO;
import com.toshaniFintech.user_service.entity.Aeps2AadharPayCommissionEntity;
import com.toshaniFintech.user_service.mapper.Aeps2AadharPayCommissionMapper;
import com.toshaniFintech.user_service.model.Aeps2AadharPayCommissionModel;
import com.toshaniFintech.user_service.repository.Aeps2AadharPayCommissionRepository;
import com.toshaniFintech.user_service.service.Aeps2AadharPayCommissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Aeps2AadharPayCommissionImpl implements Aeps2AadharPayCommissionService {

    @Autowired
    private Aeps2AadharPayCommissionRepository aeps2AadharPayCommissionRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private Aeps2AadharPayCommissionMapper aeps2AadharPayCommissionMapper;

    @Override
    public Aeps2AadharPayCommissionModel createAeps2AadharPay(Aeps2AadharPayCommissionModel aeps2AadharPayCommissionModel) {

        Aeps2AadharPayCommissionEntity aeps2AadharPayCommissionEntity = objectMapper.convertValue
                (aeps2AadharPayCommissionModel, Aeps2AadharPayCommissionEntity.class);

        Aeps2AadharPayCommissionEntity saved =
                aeps2AadharPayCommissionRepository.save(aeps2AadharPayCommissionEntity);

        return objectMapper.convertValue(saved, Aeps2AadharPayCommissionModel.class);
    }

    @Override
    public PaginatedResponse<Aeps2AadharPayCommissionResponseDTO> getAllAeps2AadharPay(
            Aeps2AadharPayCommissionRequestDTO aeps2AadharPayCommissionRequestDTO) {

        PageRequest page = Utility.pageRequest(
                aeps2AadharPayCommissionRequestDTO.getPageNo(),
                aeps2AadharPayCommissionRequestDTO.getPageSize(),
                aeps2AadharPayCommissionRequestDTO.getSortBy(),
                aeps2AadharPayCommissionRequestDTO.getOrderBy());

        Page<Aeps2AadharPayCommissionEntity> paginatedContent =
                aeps2AadharPayCommissionRepository.fetchAllAeps2AadharPay(
                aeps2AadharPayCommissionRequestDTO.getCommType(),
                aeps2AadharPayCommissionRequestDTO.getSearch(),
                aeps2AadharPayCommissionRequestDTO.getSearchByField(),
                page);

        List<Aeps2AadharPayCommissionResponseDTO> responseDTOS = new ArrayList<>();
        paginatedContent.getContent().forEach(content ->
                responseDTOS.add(aeps2AadharPayCommissionMapper.toResponseDto(content)));

        return Utility.paginatedResponseForSubList(
                paginatedContent.getNumber(),
                paginatedContent.getTotalPages(),
                paginatedContent.getSize(),
                paginatedContent.getNumberOfElements(),
                paginatedContent.getTotalElements(),
                responseDTOS);
    }

    @Override
    public Aeps2AadharPayCommissionResponseDTO getByIdAeps2AadharPay(String id) {

        Aeps2AadharPayCommissionEntity aeps2AadharPayCommissionEntity =
                aeps2AadharPayCommissionRepository.findById(id).
                        orElseThrow(() -> new RuntimeException("Aeps2 Aadhar Pay not found with id: " + id));

        return aeps2AadharPayCommissionMapper.toResponseDto(aeps2AadharPayCommissionEntity);
    }

    @Override
    public Aeps2AadharPayCommissionResponseDTO updateAeps2AadharPay(
            String id, Aeps2AadharPayCommissionModel aeps2AadharPayCommissionModel) {

        Aeps2AadharPayCommissionEntity aeps2AadharPayCommissionEntity =
                aeps2AadharPayCommissionRepository.findById(id).
                        orElseThrow(() -> new RuntimeException("Aeps2 Aadhar Pay not found with id: " + id));

        aeps2AadharPayCommissionEntity.setMinAmount(aeps2AadharPayCommissionModel.getMinAmount());
        aeps2AadharPayCommissionEntity.setMaxAmount(aeps2AadharPayCommissionModel.getMaxAmount());
        aeps2AadharPayCommissionEntity.setCommType(aeps2AadharPayCommissionModel.getCommType());
        aeps2AadharPayCommissionEntity.setComm(aeps2AadharPayCommissionModel.getComm());

        Aeps2AadharPayCommissionEntity updatedEntity =
                aeps2AadharPayCommissionRepository.save(aeps2AadharPayCommissionEntity);

        return aeps2AadharPayCommissionMapper.toResponseDto(updatedEntity);
    }

    @Override
    public void deleteAeps2AadharPay(String id) {

        Aeps2AadharPayCommissionEntity aeps2AadharPayCommissionEntity =
                aeps2AadharPayCommissionRepository.findById(id).
                        orElseThrow(() -> new RuntimeException("Aeps2 Aadhar Pay not found with id: " + id));

        aeps2AadharPayCommissionRepository.delete(aeps2AadharPayCommissionEntity);
    }
}
