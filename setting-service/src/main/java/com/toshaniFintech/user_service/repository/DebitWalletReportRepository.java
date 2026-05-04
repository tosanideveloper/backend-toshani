package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.DebitWalletReportEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DebitWalletReportRepository extends JpaRepository<DebitWalletReportEntity, String> {
    @Query("SELECT a FROM DebitWalletReportEntity a " +
            "WHERE a.txnDate BETWEEN :startDate AND :endDate " +
            "AND (:apiTxnId IS NULL OR a.apiTxnId IN :apiTxnId) " +
            "AND (:txnId IS NULL OR a.txnId IN :txnId) " +
            "AND (:status IS NULL OR a.status IN :status) " +
            "AND ( :search IS NULL OR :search = '' " +
            "   OR (:searchByField = 'txnId' AND LOWER(a.txnId) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'apiTxnId' AND LOWER(a.apiTxnId) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'apiUserDetails' AND LOWER(a.apiUserDetails) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'txnDetails' AND LOWER(a.txnDetails) LIKE LOWER(CONCAT('%', :search, '%'))) )")
    Page<DebitWalletReportEntity> fetchDebitWalletReport(
            @Param("startDate") String startDate,
            @Param("endDate") String endDate,
            @Param("apiTxnId") List<String> apiTxnId,
            @Param("txnId") List<String> txnId,
            @Param("status") List<String> status,
            @Param("search") String search,
            @Param("searchByField") String searchByField,
            PageRequest page
    );
}
