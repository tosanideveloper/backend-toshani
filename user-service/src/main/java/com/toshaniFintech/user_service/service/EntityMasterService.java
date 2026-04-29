package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.EntityMasterCreateRequest;
import com.toshaniFintech.user_service.dto.request.EntityMasterFetchRequest;
import com.toshaniFintech.user_service.dto.response.EntityMasterResponse;

public interface EntityMasterService {

    EntityMasterResponse create(EntityMasterCreateRequest request);

    EntityMasterResponse update(String uuid, EntityMasterCreateRequest request);

    EntityMasterResponse getByUuid(String uuid);

    PaginatedResponse<EntityMasterResponse> getAll(EntityMasterFetchRequest request);
}
