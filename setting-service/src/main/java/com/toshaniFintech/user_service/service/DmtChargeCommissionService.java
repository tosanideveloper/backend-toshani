package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.DmtChargeCommissionRequest;
import com.toshaniFintech.user_service.dto.response.DmtChargeCommissionResponse;
import org.springframework.data.domain.PageRequest;

public interface DmtChargeCommissionService {
    DmtChargeCommissionResponse createDmtChargeCommission(DmtChargeCommissionRequest dmtChargeCommissionRequest);

    PaginatedResponse<DmtChargeCommissionResponse> getAllDmtChargeCommission(PageRequest pageRequest);

    DmtChargeCommissionResponse getDmtChargeCommissionById(String id);

    DmtChargeCommissionResponse updateDmtChargeCommission(String id, DmtChargeCommissionRequest dmtChargeCommissionModel);

    void deleteDmtChargeCommission(String id);
}

