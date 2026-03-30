package com.toshaniFintech.auth.controller;

import com.toshaniFintech.auth.dto.AuthRequest;
import com.toshaniFintech.auth.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JwtUtil jwt;

    @PostMapping("/login")
    public Map<String,String> login(@RequestBody AuthRequest req) {

        Authentication auth = manager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        req.getUsername(),
                        req.getPassword()
                )
        );

        String role = auth.getAuthorities().iterator().next().getAuthority();

        return Map.of("token", jwt.generateToken(req.getUsername(), role));
    }
}
