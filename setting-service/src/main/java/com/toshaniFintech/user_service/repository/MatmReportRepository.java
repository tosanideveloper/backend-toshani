package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.MatmReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatmReportRepository extends JpaRepository<MatmReportEntity, String> {

    List<MatmReportEntity> findByTxnDateBetween(String startDate, String endDate);

}
