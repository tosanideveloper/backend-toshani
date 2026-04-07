package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.exception.model.UnprocessableEntityException;
import com.toshaniFintech.user_service.dto.request.IpAddressRequest;
import com.toshaniFintech.user_service.dto.response.IpAddressResponse;
import com.toshaniFintech.user_service.entity.IpAddressEntity;
import com.toshaniFintech.user_service.repository.IpAddressRepository;
import com.toshaniFintech.user_service.service.IpAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IpAddressServiceImpl implements IpAddressService {

    @Autowired
    private IpAddressRepository ipAddressRepository;

    @Override
    public IpAddressResponse createIpAddress(IpAddressRequest ipAddressRequest) {
        if (ipAddressRepository.findByName(ipAddressRequest.getName()).isPresent()) {
            throw new UnprocessableEntityException(
                "IP Address entry already exists with name: " + ipAddressRequest.getName()
            );
        }

        IpAddressEntity entity = mapToEntity(ipAddressRequest);
        IpAddressEntity savedEntity = ipAddressRepository.save(entity);
        
        return mapToModel(savedEntity);
    }

    private IpAddressEntity mapToEntity(IpAddressRequest request) {
        IpAddressEntity entity = new IpAddressEntity();
        entity.setName(request.getName());
        entity.setIpaddress(request.getIpAddress());
        entity.setIpaddressOne(request.getIpAddressOne());
        entity.setIpaddressTwo(request.getIpAddressTwo());
        entity.setIpaddressThree(request.getIpAddressThree());
        entity.setIpaddressFour(request.getIpAddressFour());
        entity.setIpaddresses(request.getIpAddresses());
        return entity;
    }

    private IpAddressResponse mapToModel(IpAddressEntity entity) {
        IpAddressResponse response = new IpAddressResponse();
        response.setName(entity.getName());
        response.setIpAddress(entity.getIpaddress());
        response.setIpAddressOne(entity.getIpaddressOne());
        response.setIpAddressTwo(entity.getIpaddressTwo());
        response.setIpAddressThree(entity.getIpaddressThree());
        response.setIpAddressFour(entity.getIpaddressFour());
        response.setIpAddresses(entity.getIpaddresses());
        return response;
    }
}