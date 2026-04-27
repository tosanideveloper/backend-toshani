package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.DmtChargeCommissionGetRequest;
import com.toshaniFintech.user_service.dto.response.DmtChargeCommissionResponse;
import com.toshaniFintech.user_service.model.DmtChargeCommissionModel;

public interface DmtChargeCommissionService {
    DmtChargeCommissionModel create(DmtChargeCommissionModel model);

    PaginatedResponse<DmtChargeCommissionResponse> fetchDmtChargeCommission(
            DmtChargeCommissionGetRequest request);
    DmtChargeCommissionResponse getById(String id);
    DmtChargeCommissionResponse update(String id, DmtChargeCommissionModel model);
    void delete(String id);
}

