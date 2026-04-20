package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.common.entity.PasswordResetToken;
import com.toshaniFintech.common.entity.Users;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken,String> {

    Optional<PasswordResetToken> findByUserId(String userId);

    @Query("SELECT p FROM PasswordResetToken p WHERE p.user.id = :userId")
    Optional<PasswordResetToken> findTokenByUserId(@Param("userId") String userId);

    Optional<PasswordResetToken> findByToken(String token);

}
