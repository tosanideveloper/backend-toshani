package com.toshaniFintech.user_service.service;

import com.toshaniFintech.user_service.dto.request.DsaBankRequestDTO;
import com.toshaniFintech.user_service.dto.response.DsaBankResponseDTO;
import com.toshaniFintech.user_service.dto.response.SettingResponse;

import java.util.List;

public interface DsaBankService {
    DsaBankResponseDTO createDsaBankService(DsaBankRequestDTO dsaBankRequestDTO);
    List<DsaBankResponseDTO> getAllDsaBanks();
}
