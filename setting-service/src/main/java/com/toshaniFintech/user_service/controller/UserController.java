package com.toshaniFintech.user_service.controller;

import com.toshaniFintech.user_service.entity.UserEntity;
import com.toshaniFintech.user_service.model.UserModel;
import com.toshaniFintech.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/setting")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/User")
    public List<UserModel> getUser(){
        List<UserModel> user = userService.getUser();
        return user;
    }

}
