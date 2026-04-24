package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.UpiExpressAccountRequestDTO;
import com.toshaniFintech.user_service.dto.response.UpiExpressAccountResponseDTO;
import com.toshaniFintech.user_service.model.UpiExpressAccountModel;

public interface UpiExpressAccountService {

    UpiExpressAccountModel create(UpiExpressAccountModel model);

    PaginatedResponse<UpiExpressAccountResponseDTO> getAll(UpiExpressAccountRequestDTO dto);

    UpiExpressAccountResponseDTO getById(String id);

    UpiExpressAccountResponseDTO update(String id, UpiExpressAccountModel model);

    void delete(String id);
}