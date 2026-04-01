package com.toshaniFintech.auth.config;

import com.toshaniFintech.auth.enitiy.AppUser;
import com.toshaniFintech.auth.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner init(UserRepository repo, PasswordEncoder encoder) {
        return args -> {
            AppUser u = new AppUser();
            u.setUsername("test");
            u.setPassword(encoder.encode("1234"));
            u.setRole("USER");
            repo.save(u);
        };
    }
}
