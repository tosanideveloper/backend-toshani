package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.RechargeReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RechargeReportRepository extends JpaRepository<RechargeReportEntity, String> {

    List<RechargeReportEntity> findByTxnDateBetween(String startDate, String endDate);

}