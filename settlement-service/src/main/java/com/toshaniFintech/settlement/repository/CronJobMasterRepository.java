package com.toshaniFintech.settlement.repository;

import com.toshaniFintech.settlement.entity.CronJobMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CronJobMasterRepository extends JpaRepository<CronJobMaster, String> {

    Optional<CronJobMaster> findByJobName(String jobName);
}