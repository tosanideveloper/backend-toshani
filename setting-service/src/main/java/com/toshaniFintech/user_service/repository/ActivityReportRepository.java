package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.ActivityReportEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityReportRepository extends JpaRepository<ActivityReportEntity, String> {

    @Query("SELECT a FROM ActivityReportEntity a " +
            "WHERE a.txnDate BETWEEN :startDate AND :endDate " +
            "AND ( :search IS NULL OR :search = '' " +
            "   OR (:searchByField = 'apiUserDetail' AND LOWER(a.apiUserDetail) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'updatedBy' AND LOWER(a.updatedBy) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'functionName' AND LOWER(a.functionName) LIKE LOWER(CONCAT('%', :search, '%'))) )")
    Page<ActivityReportEntity> fetchActivityReport(
            @Param("startDate") String startDate,
            @Param("endDate") String endDate,
            @Param("search") String search,
            @Param("searchByField") String searchByField,
            PageRequest page
    );}
