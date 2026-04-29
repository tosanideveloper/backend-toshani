package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.Aeps2AadharPayCommissionRequestDTO;
import com.toshaniFintech.user_service.dto.response.Aeps2AadharPayCommissionResponseDTO;
import com.toshaniFintech.user_service.model.Aeps2AadharPayCommissionModel;

public interface Aeps2AadharPayCommissionService {
    Aeps2AadharPayCommissionModel createAeps2AadharPay(
            Aeps2AadharPayCommissionModel aeps2AadharPayCommissionModel);

    PaginatedResponse<Aeps2AadharPayCommissionResponseDTO> getAllAeps2AadharPay(
            Aeps2AadharPayCommissionRequestDTO aeps2AadharPayCommissionRequestDTO);

    Aeps2AadharPayCommissionResponseDTO getByIdAeps2AadharPay(String id);

    Aeps2AadharPayCommissionResponseDTO updateAeps2AadharPay(
            String id, Aeps2AadharPayCommissionModel aeps2AadharPayCommissionModel);

    void deleteAeps2AadharPay(String id);
}
