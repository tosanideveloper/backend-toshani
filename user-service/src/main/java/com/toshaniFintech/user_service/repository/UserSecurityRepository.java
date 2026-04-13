package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.UserSecurity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserSecurityRepository extends JpaRepository<UserSecurity, String> {
    Optional<UserSecurity> findByUserId(String userId);
}
