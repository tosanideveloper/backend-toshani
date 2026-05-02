package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.exception.model.UnprocessableEntityException;
import com.toshaniFintech.user_service.dto.request.DsaBankRequestDTO;
import com.toshaniFintech.user_service.dto.response.DsaBankResponseDTO;
import com.toshaniFintech.user_service.entity.DsaBankEntity;
import com.toshaniFintech.user_service.entity.TicketMessagesEntity;
import com.toshaniFintech.user_service.model.TicketMessagesModel;
import com.toshaniFintech.user_service.repository.DsaBankRepository;
import com.toshaniFintech.user_service.service.DsaBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable_;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class DsaBankImpl implements DsaBankService {

    @Autowired
    private DsaBankRepository dsaBankRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public DsaBankResponseDTO createDsaBankService(DsaBankRequestDTO dsaBankRequestDTO) {

        DsaBankEntity dsaBankEntity = new DsaBankEntity();
        dsaBankEntity.setDsaBankName(dsaBankRequestDTO.getDsaBankName());
        dsaBankEntity.setDisplayName(dsaBankRequestDTO.getDisplayName());
        dsaBankEntity.setAccountName(dsaBankRequestDTO.getAccountName());
        dsaBankEntity.setAccountNumber(dsaBankRequestDTO.getAccountNumber());
        dsaBankEntity.setIfscCode(dsaBankRequestDTO.getIfscCode());

        DsaBankEntity saved = dsaBankRepository.save(dsaBankEntity);

        return objectMapper.convertValue(saved, DsaBankResponseDTO.class);
    }

    @Override
    public List<DsaBankResponseDTO> getAllDsaBanks() {
        List<DsaBankEntity> settings = dsaBankRepository.findAll();
        return settings.stream().map(this::mapToModel).collect(Collectors.toList());
    }

    private DsaBankResponseDTO mapToModel(DsaBankEntity dsaBankEntity) {
        DsaBankResponseDTO response = new DsaBankResponseDTO();
        response.setId(dsaBankEntity.getId());
        response.setDsaBankName(dsaBankEntity.getDsaBankName());
        response.setDisplayName(dsaBankEntity.getDisplayName());
        response.setAccountName(dsaBankEntity.getAccountName());
        response.setAccountNumber(dsaBankEntity.getAccountNumber());
        response.setIfscCode(dsaBankEntity.getIfscCode());
        return response;
    }
}