package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.PayoutChargeCommissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PayoutChargeCommissionRepository extends JpaRepository<PayoutChargeCommissionEntity, String> {
}
