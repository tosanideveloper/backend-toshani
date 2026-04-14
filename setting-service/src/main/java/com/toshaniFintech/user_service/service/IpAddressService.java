package com.toshaniFintech.user_service.service;

import com.toshaniFintech.user_service.dto.request.IpAddressRequest;
import com.toshaniFintech.user_service.dto.response.IpAddressResponse;

public interface IpAddressService {

    IpAddressResponse createIpAddress(IpAddressRequest ipAddressRequest);

}