package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.ClientMasterRequest;
import com.toshaniFintech.user_service.dto.response.ClientMasterResponse;

public interface ClientMasterService {

    PaginatedResponse<ClientMasterResponse> fetchClients(ClientMasterRequest request);
}