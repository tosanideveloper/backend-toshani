package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.UserMasterFetchRequestDTO;
import com.toshaniFintech.user_service.dto.request.UserMasterRequestDTO;
import com.toshaniFintech.user_service.dto.response.UserMasterResponse;

public interface UserMasterService {

    UserMasterResponse create(UserMasterRequestDTO request);

    UserMasterResponse update(String uuid, UserMasterRequestDTO request);

    UserMasterResponse getByUuid(String uuid);

    PaginatedResponse<UserMasterResponse> getAll(UserMasterFetchRequestDTO request);
}
