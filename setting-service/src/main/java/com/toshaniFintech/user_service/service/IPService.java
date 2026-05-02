package com.toshaniFintech.user_service.service;


import com.toshaniFintech.user_service.dto.request.CreateIpRequest;
import com.toshaniFintech.user_service.dto.response.CreateIpResponse;
import com.toshaniFintech.user_service.model.HolidaysModel;
import com.toshaniFintech.user_service.model.IPAddressModel;

import java.util.List;

public interface IPService {
    IPAddressModel createIpResponse(IPAddressModel ipAddressModel);

    List<IPAddressModel> getIpList();

    IPAddressModel getIpListById(String id);

    IPAddressModel updateIpAddress(String id, IPAddressModel ipAddressModel);
}


