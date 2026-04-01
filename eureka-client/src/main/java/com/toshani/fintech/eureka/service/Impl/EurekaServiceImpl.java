package com.toshani.fintech.eureka.service.Impl;

import com.toshani.fintech.eureka.service.EurekaService;
import org.springframework.stereotype.Service;

@Service
public class EurekaServiceImpl implements EurekaService {
    @Override
    public String getMessage() {
        return "Hello from Eureka Client Service";
    }
}
