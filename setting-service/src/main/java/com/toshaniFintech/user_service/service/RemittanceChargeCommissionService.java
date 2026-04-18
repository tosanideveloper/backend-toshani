package com.toshaniFintech.user_service.service;


import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.RemittanceChargeCommissionRequest;
import com.toshaniFintech.user_service.dto.request.SettingRequest;
import com.toshaniFintech.user_service.dto.response.RemittanceChargeCommissionResponse;
import com.toshaniFintech.user_service.dto.response.SettingResponse;
import org.springframework.data.domain.PageRequest;

public interface RemittanceChargeCommissionService {
    RemittanceChargeCommissionResponse createRemittanceChargeCommission
            (RemittanceChargeCommissionRequest remittanceChargeCommissionRequest);

    PaginatedResponse<RemittanceChargeCommissionResponse>
    getAllRemittanceChargeCommission(PageRequest pageRequest);

    RemittanceChargeCommissionResponse getRemittanceChargeCommissionById(String id);
}
