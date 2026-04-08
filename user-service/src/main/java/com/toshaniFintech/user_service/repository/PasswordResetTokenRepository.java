package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.common.entity.PasswordResetToken;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken,String> {

    Optional<PasswordResetToken> findByTokenAndUsedFalse(@NotBlank(message = "Token is required") String token);
}
