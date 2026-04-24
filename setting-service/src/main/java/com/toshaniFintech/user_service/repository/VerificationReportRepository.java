package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.VerificationReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VerificationReportRepository extends JpaRepository<VerificationReportEntity, String> {

    List<VerificationReportEntity> findByTxnDateBetween(String startDate, String endDate);

}