package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.Aeps3AadharPayCommissionRequestDTO;
import com.toshaniFintech.user_service.dto.response.Aeps3AadharPayCommissionResponseDTO;
import com.toshaniFintech.user_service.model.Aeps3AadharPayCommissionModel;

public interface Aeps3AadharPayCommissionService {
    Aeps3AadharPayCommissionModel createAeps3AadharPay(
            Aeps3AadharPayCommissionModel aeps3AadharPayCommissionModel);

    PaginatedResponse<Aeps3AadharPayCommissionResponseDTO> getAllAeps3AadharPay(
            Aeps3AadharPayCommissionRequestDTO aeps3AadharPayCommissionRequestDTO);

    Aeps3AadharPayCommissionResponseDTO getByIdAeps3AadharPay(String id);

    Aeps3AadharPayCommissionResponseDTO updateAeps3AadharPay(
            String id, Aeps3AadharPayCommissionModel aeps3AadharPayCommissionModel);

    void deleteAeps3AadharPay(String id);
}
