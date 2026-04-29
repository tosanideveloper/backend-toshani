package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.ChannelMasterFetchRequest;
import com.toshaniFintech.user_service.dto.request.ChannelMasterCreateRequest;
import com.toshaniFintech.user_service.dto.response.ChannelMasterResponse;

public interface ChannelMasterService {

    ChannelMasterResponse create(ChannelMasterCreateRequest request);

    ChannelMasterResponse update(String uuid, ChannelMasterCreateRequest request);

    ChannelMasterResponse getByUuid(String uuid);

    PaginatedResponse<ChannelMasterResponse> getAll(ChannelMasterFetchRequest request);
}
