package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.CreditCardChargeCommissionGetRequestDTO;
import com.toshaniFintech.user_service.dto.response.CreditCardChargeCommissionResponseDTO;
import com.toshaniFintech.user_service.model.CreditCardChargeCommissionModel;

public interface CreditCardChargeCommissionService {

    CreditCardChargeCommissionModel create(CreditCardChargeCommissionModel model);

    PaginatedResponse<CreditCardChargeCommissionResponseDTO> fetchCreditCardChargeCommission(
            CreditCardChargeCommissionGetRequestDTO requestDTO
    );
    CreditCardChargeCommissionResponseDTO getById(String id);
    CreditCardChargeCommissionResponseDTO update(String id, CreditCardChargeCommissionModel model);
    void delete(String id);

}