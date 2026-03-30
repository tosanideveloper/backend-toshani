package com.toshaniFintech.user_service.service;

import com.toshaniFintech.user_service.entity.UserEntity;
import com.toshaniFintech.user_service.model.UserModel;

import java.util.List;

public interface UserService {
    List<UserModel> getUser();
}
