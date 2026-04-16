package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.Aeps1ReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface Aeps1ReportRepository extends JpaRepository<Aeps1ReportEntity, String>,
        JpaSpecificationExecutor<Aeps1ReportEntity> {
}