package com.toshaniFintech.user_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaAuditing
@SpringBootApplication(scanBasePackages = "com.toshaniFintech")
@EntityScan(basePackages = {
        "com.toshaniFintech.user_service.entity",
        "com.toshaniFintech.common.entity"
})
@EnableJpaRepositories(basePackages = {
        "com.toshaniFintech.user_service.repository",
        "com.toshaniFintech.common.repository"
})
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
