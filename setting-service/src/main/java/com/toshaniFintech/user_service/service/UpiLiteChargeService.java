package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.UpiLiteChargeRequestDTO;
import com.toshaniFintech.user_service.dto.response.UpiLiteChargeResponseDTO;
import com.toshaniFintech.user_service.model.UpiLiteChargeModel;

public interface UpiLiteChargeService {

    UpiLiteChargeModel create(UpiLiteChargeModel model);

    PaginatedResponse<UpiLiteChargeResponseDTO> getAll(UpiLiteChargeRequestDTO dto);

    UpiLiteChargeResponseDTO getById(String id);

    UpiLiteChargeResponseDTO update(String id, UpiLiteChargeModel model);

    void delete(String id);
}