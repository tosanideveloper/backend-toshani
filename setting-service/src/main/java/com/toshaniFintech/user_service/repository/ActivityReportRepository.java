package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.ActivityReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActivityReportRepository extends JpaRepository<ActivityReportEntity, String> {

    Optional<ActivityReportEntity> findById(String Id);
}
