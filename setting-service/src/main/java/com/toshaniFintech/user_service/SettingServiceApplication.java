package com.toshaniFintech.user_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication(scanBasePackages = "com.toshaniFintech")
public class SettingServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SettingServiceApplication.class, args);
    }
}
