package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.CollectionWalletReportEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CollectionWalletReportRepository extends JpaRepository<CollectionWalletReportEntity,String> {
    @Query("SELECT a FROM CollectionWalletReportEntity a " +
            "WHERE a.txnDate BETWEEN :startDate AND :endDate " +
            "AND (:txnId IS NULL OR a.txnId IN :txnId) " +
            "AND ( :search IS NULL OR :search = '' " +
            "   OR (:searchByField = 'txnID' AND LOWER(a.txnId) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'apiUserDetails' AND LOWER(a.apiUserDetails) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'txnDetails' AND LOWER(a.txnDetails) LIKE LOWER(CONCAT('%', :search, '%'))) )")
    Page<CollectionWalletReportEntity> fetchCollectionWalletReport(
            @Param("startDate") String startDate,
            @Param("endDate") String endDate,
            @Param("txnId") List<String> txnId,
            @Param("search") String search,
            @Param("searchByField") String searchByField,
            PageRequest page
    );
}
