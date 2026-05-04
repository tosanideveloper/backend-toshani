package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.Aeps1CommissionGetAll;
import com.toshaniFintech.user_service.dto.request.Aeps1CommissionRequestDTO;
import com.toshaniFintech.user_service.dto.response.Aeps1CommissionResponseDTO;
import com.toshaniFintech.user_service.model.Aeps1CommissionModel;

public interface Aeps1CommissionService {
    Aeps1CommissionModel create(Aeps1CommissionModel aeps1CommissionModel);

    PaginatedResponse<Aeps1CommissionResponseDTO> getAll(Aeps1CommissionGetAll aeps1CommissionGetAll);

    Aeps1CommissionResponseDTO getById(String id);

    Aeps1CommissionResponseDTO update(String id, Aeps1CommissionModel aeps1CommissionModel);

    void delete(String id);
}
