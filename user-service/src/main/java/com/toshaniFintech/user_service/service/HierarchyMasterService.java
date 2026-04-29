package com.toshaniFintech.user_service.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.user_service.dto.request.HierarchyMasterCreateRequest;
import com.toshaniFintech.user_service.dto.request.HierarchyMasterFetchRequest;
import com.toshaniFintech.user_service.dto.response.HierarchyMasterResponse;

public interface HierarchyMasterService {

    HierarchyMasterResponse create(HierarchyMasterCreateRequest request);

    HierarchyMasterResponse update(String uuid, HierarchyMasterCreateRequest request);

    HierarchyMasterResponse getByUuid(String uuid);

    PaginatedResponse<HierarchyMasterResponse> getAll(HierarchyMasterFetchRequest request);
}
