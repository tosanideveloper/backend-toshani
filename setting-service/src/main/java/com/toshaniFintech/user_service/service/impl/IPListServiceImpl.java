package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.exception.model.NotFoundException;
import com.toshaniFintech.user_service.dto.request.CreateIpRequest;
import com.toshaniFintech.user_service.dto.response.CreateIpResponse;
import com.toshaniFintech.user_service.entity.IPAddressesEntity;
import com.toshaniFintech.user_service.model.IPAddressModel;
import com.toshaniFintech.user_service.repository.IPListRepository;
import com.toshaniFintech.user_service.service.IPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IPListServiceImpl implements IPService {

    @Autowired
    private IPListRepository ipListRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<IPAddressModel> getIpList() {

        List<IPAddressesEntity> all = ipListRepository.findAll();
        return all.stream()
                .map(entity -> objectMapper.convertValue(entity, IPAddressModel.class))
                .toList();
    }

    @Override
    public IPAddressModel getIpListById(String id) {
        IPAddressesEntity entity = ipListRepository.findById(id).orElseThrow(() -> new NotFoundException("Setting not found with id: " + id));
        return mapToModel(entity);
    }

    @Override
    public CreateIpResponse createIpResponse(CreateIpRequest createIpRequest) {
        IPAddressesEntity entity = new IPAddressesEntity();
        entity.setName(createIpRequest.getName());
        entity.setIpAddress(createIpRequest.getIpAddress());
        entity.setIpAddressOne(createIpRequest.getIpAddressOne());
        entity.setIpAddressTwo(createIpRequest.getIpAddressTwo());
        entity.setIpAddressThree(createIpRequest.getIpAddressThree());
        entity.setIpAddressFour(createIpRequest.getIpAddressFour());
        entity.setIpAddresses(createIpRequest.getIpAddresses());

        IPAddressesEntity saved = ipListRepository.save(entity);
        CreateIpResponse response = new CreateIpResponse();
                return response;

        }

    @Override
    public IPAddressModel updateIpAddress(Long id, CreateIpRequest createIpRequest) {
        IPAddressesEntity entity = new IPAddressesEntity();
        entity.setName(createIpRequest.getName());
        entity.setIpAddress(createIpRequest.getIpAddress());
        entity.setIpAddressOne(createIpRequest.getIpAddressOne());
        entity.setIpAddressTwo(createIpRequest.getIpAddressTwo());
        entity.setIpAddressThree(createIpRequest.getIpAddressThree());
        entity.setIpAddressFour(createIpRequest.getIpAddressFour());
        entity.setIpAddresses(createIpRequest.getIpAddresses());

        IPAddressesEntity saved = ipListRepository.save(entity);

        return objectMapper.convertValue(saved,IPAddressModel.class);

    }
    private IPAddressModel mapToModel(IPAddressesEntity entity) {
        CreateIpResponse response = new CreateIpResponse();
        response.setName(entity.getName());
        response.setIpAddress(entity.getIpAddress());
        response.setIpAddressOne(entity.getIpAddressOne());
        response.setIpAddressTwo(entity.getIpAddressTwo());
        response.setIpAddressThree(entity.getIpAddressThree());
        response.setIpAddressFour(entity.getIpAddressFour());
        response.setIpAddresses(entity.getIpAddresses());


        return objectMapper.convertValue(entity, IPAddressModel.class);
    }
}
