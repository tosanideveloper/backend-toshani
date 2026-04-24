package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.AmcReportEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmcReportRepository extends JpaRepository<AmcReportEntity, String> {

    @Query("SELECT a FROM AmcReportEntity a " +
            "WHERE a.emiCreateDate BETWEEN :startDate AND :endDate " +
            "AND (:txnId IS NULL OR a.emiCollectionTxnId IN :txnId) " +
            "AND ( :search IS NULL OR :search = '' " +
            "   OR (:searchByField = 'emiCollectionTxnId' AND LOWER(a.emiCollectionTxnId) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'companyName' AND LOWER(a.companyName) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'agentDetail' AND LOWER(a.agentDetail) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'totalCollectionAmt' AND LOWER(a.totalCollectionAmt) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'emiAmount' AND LOWER(a.emiAmount) LIKE LOWER(CONCAT('%', :search, '%'))) )" )

    Page<AmcReportEntity> fetchAmcReport(
            @Param("startDate") String startDate,
            @Param("endDate") String endDate,
            @Param("txnId") List<String> txnId,
            @Param("search") String search,
            @Param("searchByField") String searchByField,
            PageRequest page
    );
}
