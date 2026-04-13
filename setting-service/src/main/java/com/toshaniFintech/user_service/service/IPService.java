package com.toshaniFintech.user_service.service;


import com.toshaniFintech.user_service.dto.request.CreateIpRequest;
import com.toshaniFintech.user_service.dto.response.CreateIpResponse;
import com.toshaniFintech.user_service.model.IPAddressModel;

import java.util.List;

public interface IPService {
    CreateIpResponse createIpResponse(CreateIpRequest createIpRequest);

    List<IPAddressModel> getIpList();
    IPAddressModel getIpListById(String id);

    IPAddressModel updateIpAddress(Long id, CreateIpRequest request);
}


