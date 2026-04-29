package com.toshaniFintech.settlement.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Audit log for cron job executions (BOD/EOD snapshots, settlement processing).
 * Enables admin to verify when jobs last ran and whether they succeeded.
 */
@Getter
@Setter
@Entity
@Table(name = "th_cronjob_master")
public class CronJobMaster extends BaseEntity {

    @Column(name = "uuid", nullable = false, unique = true)
    private String uuid;

    @Column(name = "job_name", nullable = false)
    private String jobName;

    @Column(name = "last_run_at")
    private LocalDateTime lastRunAt;

    @Column(name = "next_run_at")
    private LocalDateTime nextRunAt;

    // SUCCESS or FAILED
    @Column(name = "last_run_status")
    private String lastRunStatus;

    @Column(name = "remarks")
    private String remarks;
}