package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.Aeps2CommissionRequestDTO;
import com.toshaniFintech.user_service.dto.response.Aeps2CommissionResponseDTO;
import com.toshaniFintech.user_service.model.Aeps2CommissionModel;

public interface Aeps2CommissionService {
    Aeps2CommissionModel create(Aeps2CommissionModel aeps2CommissionModel);

    PaginatedResponse<Aeps2CommissionResponseDTO> getAll(Aeps2CommissionRequestDTO aeps2CommissionRequestDTO);

    Aeps2CommissionResponseDTO getById(String id);

    Aeps2CommissionResponseDTO update(String id, Aeps2CommissionModel aeps2CommissionModel);

    void delete(String id);
}
