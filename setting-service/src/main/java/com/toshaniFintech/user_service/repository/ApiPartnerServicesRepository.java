package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.ApiPartnerServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApiPartnerServicesRepository extends JpaRepository<ApiPartnerServiceEntity, String> {
    Optional<ApiPartnerServiceEntity> findByServiceName(String settingKey);
}
