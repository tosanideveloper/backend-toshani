package com.toshaniFintech.user_service.service;

import com.toshaniFintech.user_service.dto.request.DsaBankRequestDTO;
import com.toshaniFintech.user_service.dto.response.DsaBankResponseDTO;

import java.util.List;

public interface DsaBankService {
    DsaBankResponseDTO createDsaBankService(DsaBankRequestDTO dsaBankRequestDTO);

    List<DsaBankResponseDTO> getAllDsaBanks();

    DsaBankResponseDTO getDsaBankById(String id);

    DsaBankResponseDTO updateDsaBank(String id, DsaBankRequestDTO dsaBankRequestDTO);
}
