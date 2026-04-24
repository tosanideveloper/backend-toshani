package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.PaytmPosChargeRequestDTO;
import com.toshaniFintech.user_service.dto.response.PaytmPosChargeResponseDTO;
import com.toshaniFintech.user_service.model.PaytmPosChargeModel;

public interface PaytmPosChargeService {

    PaytmPosChargeModel create(PaytmPosChargeModel model);

    PaginatedResponse<PaytmPosChargeResponseDTO> getAll(PaytmPosChargeRequestDTO requestDTO);

    PaytmPosChargeResponseDTO getById(String id);

    PaytmPosChargeResponseDTO update(String id, PaytmPosChargeModel model);

    void delete(String id);
}