package com.toshaniFintech.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.toshaniFintech")
@EntityScan(basePackages = {
        "com.toshaniFintech.auth.entity",
        "com.toshaniFintech.common.entity"
})
@EnableJpaRepositories(basePackages = {
        "com.toshaniFintech.auth.repository",
        "com.toshaniFintech.common.repository"
})
public class AuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}

}
