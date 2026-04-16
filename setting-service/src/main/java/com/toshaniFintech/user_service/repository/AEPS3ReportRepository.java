package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.AEPS3ReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AEPS3ReportRepository extends JpaRepository<AEPS3ReportEntity, String> {
}
