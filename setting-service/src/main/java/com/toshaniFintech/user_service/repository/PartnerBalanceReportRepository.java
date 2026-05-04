package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.PartnerBalanceReportEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartnerBalanceReportRepository extends JpaRepository<PartnerBalanceReportEntity,String> {
    @Query("SELECT a FROM PartnerBalanceReportEntity a " +
            "WHERE a.txnDate BETWEEN :startDate AND :endDate " +
            "AND (:userId IS NULL OR a.userId IN :userId) " +
            "AND ( :search IS NULL OR :search = '' " +
            "   OR (:searchByField = 'userId' AND LOWER(a.userId) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'companyDetails' AND LOWER(a.companyDetails) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'userType' AND LOWER(a.userType) LIKE LOWER(CONCAT('%', :search, '%'))) )")
    Page<PartnerBalanceReportEntity> fetchPartnerBalanceReport(
            @Param("startDate") String startDate,
            @Param("endDate") String endDate,
            @Param("userId") List<String> userId,
            @Param("search") String search,
            @Param("searchByField") String searchByField,
            PageRequest page
    );
}
