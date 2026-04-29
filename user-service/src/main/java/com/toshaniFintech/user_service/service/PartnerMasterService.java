package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.PartnerMasterRequest;
import com.toshaniFintech.user_service.dto.response.PartnerMasterResponse;

public interface PartnerMasterService {

    PaginatedResponse<PartnerMasterResponse> fetchPartners(PartnerMasterRequest request);
}
