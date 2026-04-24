package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.CardPayChargeRequestDTO;
import com.toshaniFintech.user_service.dto.response.CardPayChargeResponseDTO;
import com.toshaniFintech.user_service.model.CardPayChargeModel;

public interface CardPayChargeService {

    CardPayChargeModel create(CardPayChargeModel model);

    PaginatedResponse<CardPayChargeResponseDTO> getAll(CardPayChargeRequestDTO dto);

    CardPayChargeResponseDTO getById(String id);

    CardPayChargeResponseDTO update(String id, CardPayChargeModel model);

    void delete(String id);
}