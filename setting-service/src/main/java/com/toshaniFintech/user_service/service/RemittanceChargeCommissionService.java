package com.toshaniFintech.user_service.service;


import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.RemittanceChargeCommissionRequest;
import com.toshaniFintech.user_service.dto.response.RemittanceChargeCommissionResponse;
import org.springframework.data.domain.PageRequest;

public interface RemittanceChargeCommissionService {
    RemittanceChargeCommissionResponse createRemittanceChargeCommission
            (RemittanceChargeCommissionRequest remittanceChargeCommissionRequest);

    PaginatedResponse<RemittanceChargeCommissionResponse>
    getAllRemittanceChargeCommission(PageRequest pageRequest);

    RemittanceChargeCommissionResponse getRemittanceChargeCommissionById(String id);
    RemittanceChargeCommissionResponse updateRemittanceChargeCommission(String id, RemittanceChargeCommissionRequest remittanceChargeCommissionModel);

    void deleteRemittanceChargeCommission(String id);
}
