package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.ManageSettlementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManageSettlementRepository extends JpaRepository<ManageSettlementEntity,String> {
}
