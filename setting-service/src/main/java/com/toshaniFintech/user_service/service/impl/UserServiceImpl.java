package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.user_service.entity.UserEntity;
import com.toshaniFintech.user_service.model.UserModel;
import com.toshaniFintech.user_service.repository.UserRepository;
import com.toshaniFintech.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public List<UserModel> getUser() {

        List<UserEntity> all = userRepository.findAll();
        List<UserModel> userModels = all.stream()
                .map(entity -> objectMapper.convertValue(entity, UserModel.class))
                .toList();
        return userModels;
    }
}
