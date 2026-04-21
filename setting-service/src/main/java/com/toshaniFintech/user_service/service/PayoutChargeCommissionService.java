package com.toshaniFintech.user_service.service;

import com.toshaniFintech.user_service.dto.request.PayoutChargeCommissionRequest;
import com.toshaniFintech.user_service.dto.response.PayoutChargeCommissionResponse;

public interface PayoutChargeCommissionService {
    PayoutChargeCommissionResponse createPayoutChargeCommission
            (PayoutChargeCommissionRequest payoutChargeCommissionRequest);
    PayoutChargeCommissionResponse getPayoutChargeCommissionById(String id);
    PayoutChargeCommissionResponse updatePayoutChargeCommission(String id, PayoutChargeCommissionRequest payoutChargeCommissionModel);
}
