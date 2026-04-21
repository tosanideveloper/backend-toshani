package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.RemittanceChargeCommissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RemittanceChargeCommissionRepository extends JpaRepository<RemittanceChargeCommissionEntity, String> {
}
