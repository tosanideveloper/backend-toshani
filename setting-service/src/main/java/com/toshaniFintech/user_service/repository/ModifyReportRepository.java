package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.ModifyReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModifyReportRepository extends JpaRepository<ModifyReportEntity, String> {

    List<ModifyReportEntity> findByTxnDateBetween(String startDate, String endDate);

}