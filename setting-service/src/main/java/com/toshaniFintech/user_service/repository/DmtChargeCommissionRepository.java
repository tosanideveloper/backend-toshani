package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.DmtChargeCommissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DmtChargeCommissionRepository extends JpaRepository<DmtChargeCommissionEntity, String> {
}
