package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.Aeps1AadharPayCommissionRequestDTO;
import com.toshaniFintech.user_service.dto.response.Aeps1AadharPayCommissionResponseDTO;
import com.toshaniFintech.user_service.model.Aeps1AadharPayCommissionModel;

public interface Aeps1AadharPayCommissionService {
    Aeps1AadharPayCommissionModel create(Aeps1AadharPayCommissionModel aeps1AadharPayCommissionModel);

    PaginatedResponse<Aeps1AadharPayCommissionResponseDTO> getAll(
            Aeps1AadharPayCommissionRequestDTO aeps1AadharPayCommissionRequestDTO);

    Aeps1AadharPayCommissionResponseDTO getById(String id);

    Aeps1AadharPayCommissionResponseDTO update(String id, Aeps1AadharPayCommissionModel aeps1AadharPayCommissionModel);

    void delete(String id);
}
