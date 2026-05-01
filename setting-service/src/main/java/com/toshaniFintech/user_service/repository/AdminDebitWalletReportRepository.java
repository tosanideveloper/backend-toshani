package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.AdminDebitWalletReportEntity;
import com.toshaniFintech.user_service.entity.CollectionWalletReportEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminDebitWalletReportRepository extends JpaRepository<AdminDebitWalletReportEntity,String> {
    @Query("SELECT a FROM AdminDebitWalletReportEntity a " +
            "WHERE a.txnDate BETWEEN :startDate AND :endDate " +
            "AND (:txnId IS NULL OR a.txnId IN :txnId) " +
            "AND ( :search IS NULL OR :search = '' " +
            "   OR (:searchByField = 'txnId' AND LOWER(a.txnId) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'apiName' AND LOWER(a.apiName) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'key' AND LOWER(a.key) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'updatedBy' AND LOWER(a.updatedBy) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'txnDetails' AND LOWER(a.txnDetails) LIKE LOWER(CONCAT('%', :search, '%'))) )")
    Page<AdminDebitWalletReportEntity> fetchAdminDebitWalletReport(
            @Param("startDate") String startDate,
            @Param("endDate") String endDate,
            @Param("txnId") List<String> txnId,
            @Param("search") String search,
            @Param("searchByField") String searchByField,
            PageRequest page
    );
}
