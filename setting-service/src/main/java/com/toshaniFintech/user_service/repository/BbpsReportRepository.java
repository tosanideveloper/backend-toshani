package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.BbpsReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BbpsReportRepository extends JpaRepository<BbpsReportEntity, String> {

    List<BbpsReportEntity> findByTxnDateBetween(String startDate, String endDate);

}