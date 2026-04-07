package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.user_service.dto.response.ApiSwitchingUserResponseDTO;
import com.toshaniFintech.user_service.entity.ApiSwitchingUserEntity;
import com.toshaniFintech.user_service.exception.NotFoundException;
import com.toshaniFintech.user_service.model.ApiSwitchingUserModel;
import com.toshaniFintech.user_service.repository.ApiSwitchingUserRepository;
import com.toshaniFintech.user_service.service.SwitchingUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiSwitchingUserImpl implements SwitchingUserService {

    @Autowired
    private ApiSwitchingUserRepository apiSwitchingUserRepository;


    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<ApiSwitchingUserModel> getApiSwitchingUser() {
        List<ApiSwitchingUserEntity> apiSwitchingUserEntitiesList = apiSwitchingUserRepository.findAll();
        return apiSwitchingUserEntitiesList.stream()
                .map(apiSwitchingUserEntity -> objectMapper.convertValue
                        (apiSwitchingUserEntity, ApiSwitchingUserModel.class)).toList();
    }

    @Override
    public ApiSwitchingUserModel getSwitchUserByID(String id) {
        ApiSwitchingUserEntity entity = apiSwitchingUserRepository.findById(id).orElseThrow(() -> new NotFoundException("Switching User not found with id: " + id));
        return mapToModel(entity);
    }

    @Override
    public ApiSwitchingUserModel updateSwitchUser(String id, ApiSwitchingUserModel apiSwitchingUserModel) {
        ApiSwitchingUserEntity entity = apiSwitchingUserRepository.findById(id).orElseThrow(() -> new NotFoundException("Switching User not found with id: " + id));
        entity.setSwitchCategoryCode(apiSwitchingUserModel.getSwitchCategoryCode());
        entity.setSwitchCategoryName(apiSwitchingUserModel.getSwitchCategoryName());
        entity.setSwitchIP(apiSwitchingUserModel.getSwitchIP());


        ApiSwitchingUserEntity saved = apiSwitchingUserRepository.save(entity);

        return objectMapper.convertValue(saved, ApiSwitchingUserModel.class);
    }

    private ApiSwitchingUserModel mapToModel(ApiSwitchingUserEntity entity) {
        ApiSwitchingUserResponseDTO response = new ApiSwitchingUserResponseDTO();
        response.setId(entity.getId());
        response.setSwitchCategoryCode(entity.getSwitchCategoryCode());
        response.setSwitchCategoryName(entity.getSwitchCategoryName());
        response.setSwitchIP(entity.getSwitchIP());

        return objectMapper.convertValue(entity, ApiSwitchingUserModel.class);
    }

}
