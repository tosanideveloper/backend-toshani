package com.toshaniFintech.user_service.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1//user")
public class UserController {

    @GetMapping
    public List<String> getUsers(
            @RequestHeader("X-User") String username,
            @RequestHeader("X-Role") String role
    ) {

        return List.of(
                "Logged in user: " + username,
                "Role: " + role,
                "User1",
                "User2",
                "User3"
        );
    }
}