package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.exception.model.NotFoundException;
import com.toshaniFintech.common.exception.model.UnprocessableEntityException;
import com.toshaniFintech.user_service.dto.request.DsaBankRequestDTO;
import com.toshaniFintech.user_service.dto.response.DsaBankResponseDTO;
import com.toshaniFintech.user_service.entity.DsaBankEntity;
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
        if (dsaBankRepository.findByDsaBankName(dsaBankRequestDTO.getDsaBankName()).isPresent()) {
            throw new UnprocessableEntityException("DSA Bank already exists with key: " + dsaBankRequestDTO.getDsaBankName());
        }
        DsaBankEntity dsaBankEntity = dsaBankRepository.findById(String.valueOf(AbstractPersistable_.id)).orElseThrow(() -> new RuntimeException("Dsa Bank not found with id: " + id));
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

    @Override
    public DsaBankResponseDTO getDsaBankById(String id) {
        DsaBankEntity entity = dsaBankRepository.findById(id).orElseThrow(() -> new NotFoundException("DSA Bank not found with id: " + id));
        return mapToModel(entity);
    }

    @Override
    public DsaBankResponseDTO updateDsaBank(String id, DsaBankRequestDTO dsaBankRequestDTO) {
        DsaBankEntity dsaBankEntity = dsaBankRepository.findById(id).orElseThrow(() -> new NotFoundException("DSA Bank not found with id: " + id));

        dsaBankEntity.setDsaBankName(dsaBankRequestDTO.getDsaBankName());
        dsaBankEntity.setDisplayName(dsaBankRequestDTO.getDisplayName());
        dsaBankEntity.setAccountName(dsaBankRequestDTO.getAccountName());
        dsaBankEntity.setAccountNumber(dsaBankRequestDTO.getAccountNumber());
        dsaBankEntity.setIfscCode(dsaBankRequestDTO.getIfscCode());
        DsaBankEntity saved = dsaBankRepository.save(dsaBankEntity);
        return mapToModel(dsaBankEntity);
    }
    private DsaBankResponseDTO mapToModel(DsaBankEntity dsaBankEntity) {
        DsaBankResponseDTO response = new DsaBankResponseDTO();
        response.setDsaBankName(dsaBankEntity.getDsaBankName());
        response.setDisplayName(dsaBankEntity.getDisplayName());
        response.setAccountName(dsaBankEntity.getAccountName());
        response.setAccountNumber(dsaBankEntity.getAccountNumber());
        response.setIfscCode(dsaBankEntity.getIfscCode());
        return response;
    }
}
