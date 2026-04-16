package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.AEPS2ReportEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AEPS2ReportRepository extends JpaRepository<AEPS2ReportEntity, String> {
}
