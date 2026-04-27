package com.toshaniFintech.user_service.service;


import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.RemittanceChargeCommissionGetRequest;
import com.toshaniFintech.user_service.dto.response.RemittanceChargeCommissionResponse;
import com.toshaniFintech.user_service.model.RemittanceChargeCommissionModel;

public interface RemittanceChargeCommissionService {
    RemittanceChargeCommissionModel create(RemittanceChargeCommissionModel model);

    PaginatedResponse<RemittanceChargeCommissionResponse> fetchRemittanceChargeCommission(
            RemittanceChargeCommissionGetRequest request
    );
    RemittanceChargeCommissionResponse getById(String id);
    RemittanceChargeCommissionResponse update(String id, RemittanceChargeCommissionModel model);
    void delete(String id);
}
