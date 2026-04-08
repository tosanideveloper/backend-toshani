package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.ApiSwitchingUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiSwitchingUserRepository extends JpaRepository<ApiSwitchingUserEntity, String> {
}
