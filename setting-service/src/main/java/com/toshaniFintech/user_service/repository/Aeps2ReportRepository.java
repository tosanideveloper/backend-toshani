package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.Aeps2ReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Aeps2ReportRepository extends JpaRepository<Aeps2ReportEntity, String>
{
}