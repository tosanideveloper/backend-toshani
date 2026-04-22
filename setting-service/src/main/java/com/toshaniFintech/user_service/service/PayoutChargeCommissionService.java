package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.PayoutChargeCommissionRequest;
import com.toshaniFintech.user_service.dto.response.PayoutChargeCommissionResponse;
import org.springframework.data.domain.PageRequest;

public interface PayoutChargeCommissionService {
    PayoutChargeCommissionResponse createPayoutChargeCommission
            (PayoutChargeCommissionRequest payoutChargeCommissionRequest);
    PayoutChargeCommissionResponse getPayoutChargeCommissionById(String id);
    PayoutChargeCommissionResponse updatePayoutChargeCommission
            (String id, PayoutChargeCommissionRequest payoutChargeCommissionModel);
    PaginatedResponse< PayoutChargeCommissionResponse> getAllPayoutChargeCommission(PageRequest pageRequest);
    void deletePayoutChargeCommission(String id);
}
