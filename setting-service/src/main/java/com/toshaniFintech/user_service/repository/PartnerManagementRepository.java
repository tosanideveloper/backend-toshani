package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.PartnerManagementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartnerManagementRepository extends JpaRepository<PartnerManagementEntity, String> {
    Optional<PartnerManagementEntity> findByMobileNumber(String mobileNumber);

}