package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.PartnerManagementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PartnerManagementRepository extends JpaRepository<PartnerManagementEntity, String> {
    Optional<PartnerManagementEntity> findByMobileNumber(String mobileNumber);

}