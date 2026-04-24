package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.ExpressUpiChargeRequestDTO;
import com.toshaniFintech.user_service.dto.response.ExpressUpiChargeResponseDTO;
import com.toshaniFintech.user_service.model.ExpressUpiChargeModel;

public interface ExpressUpiChargeService {

    ExpressUpiChargeModel create(ExpressUpiChargeModel model);

    PaginatedResponse<ExpressUpiChargeResponseDTO> getAll(ExpressUpiChargeRequestDTO requestDTO);

    ExpressUpiChargeResponseDTO getById(String id);

    ExpressUpiChargeResponseDTO update(String id, ExpressUpiChargeModel model);

    void delete(String id);
}