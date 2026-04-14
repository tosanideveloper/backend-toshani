package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.PartnerManagementEntity;
import com.toshaniFintech.user_service.entity.ReconciliationReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReconciliationReportRepository extends JpaRepository<ReconciliationReportEntity, String> {
}
