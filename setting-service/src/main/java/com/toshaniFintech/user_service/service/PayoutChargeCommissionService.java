package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.PayoutChargeCommissionGetRequest;
import com.toshaniFintech.user_service.dto.response.PayoutChargeCommissionResponse;
import com.toshaniFintech.user_service.model.PayoutChargeCommissionModel;

public interface PayoutChargeCommissionService {
    PayoutChargeCommissionModel create(PayoutChargeCommissionModel model);

    PaginatedResponse<PayoutChargeCommissionResponse> fetchPayoutChargeCommission(
            PayoutChargeCommissionGetRequest request);
    PayoutChargeCommissionResponse getById(String id);
    PayoutChargeCommissionResponse update(String id, PayoutChargeCommissionModel model);
    void delete(String id);
}
