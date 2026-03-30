package com.toshani.fintech.eureka.controller;

import com.toshani.fintech.eureka.service.EurekaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ClientController {
    @Autowired
    private EurekaService eurekaService;

    @GetMapping("/hello")
    public String hello() {
        return eurekaService.getMessage();
    }
}
