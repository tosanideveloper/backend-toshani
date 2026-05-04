package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.MatmCommissionGetAll;
import com.toshaniFintech.user_service.dto.request.MatmCommissionRequestDTO;
import com.toshaniFintech.user_service.dto.response.MatmCommissionResponseDTO;
import com.toshaniFintech.user_service.model.MatmCommissionModel;

public interface MatmCommissionService {
    MatmCommissionModel create(MatmCommissionModel matmCommissionModel);

    PaginatedResponse<MatmCommissionResponseDTO> getAll(MatmCommissionGetAll matmCommissionGetAll);

    MatmCommissionResponseDTO getById(String id);

    MatmCommissionResponseDTO update(String id, MatmCommissionModel matmCommissionModel);

    void delete(String id);
}
