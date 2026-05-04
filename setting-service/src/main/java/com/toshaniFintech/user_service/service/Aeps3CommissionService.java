package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.Aeps3CommissionGetAll;
import com.toshaniFintech.user_service.dto.request.Aeps3CommissionRequestDTO;
import com.toshaniFintech.user_service.dto.response.Aeps3CommissionResponseDTO;
import com.toshaniFintech.user_service.model.Aeps3CommissionModel;

public interface Aeps3CommissionService {
    Aeps3CommissionModel createAeps3(Aeps3CommissionModel aeps3CommissionModel);

    PaginatedResponse<Aeps3CommissionResponseDTO> getAllAeps3(Aeps3CommissionGetAll aeps3CommissionGetAll);

    Aeps3CommissionResponseDTO getByIdAeps3(String id);

    Aeps3CommissionResponseDTO updateAeps3(String id, Aeps3CommissionModel aeps3CommissionModel);

    void deleteAeps3(String id);
}
