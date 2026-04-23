package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.BbpsReportEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BbpsReportRepository extends JpaRepository<BbpsReportEntity, String> {

    @Query("SELECT a FROM BbpsReportEntity a " +
            "WHERE a.txnDate BETWEEN :startDate AND :endDate " +
            "AND (:orderId IS NULL OR a.orderID IN :orderId) " +
            "AND (:txnId IS NULL OR a.txnID IN :txnId) " +
            "AND (:type IS NULL OR a.type IN :type) " +
            "AND (:status IS NULL OR a.status IN :status) " +
            "AND ( :search IS NULL OR :search = '' " +
            "   OR (:searchByField = 'txnID' AND LOWER(a.txnID) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'orderID' AND LOWER(a.orderID) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'rrn' AND LOWER(a.rrn) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'type' AND LOWER(a.type) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'status' AND LOWER(a.status) LIKE LOWER(CONCAT('%', :search, '%'))) )")
    Page<BbpsReportEntity> fetchBbpsReport(
            @Param("startDate") String startDate,
            @Param("endDate") String endDate,
            @Param("orderId") List<String> orderId,
            @Param("txnId") List<String> txnId,
            @Param("type") List<String> type,
            @Param("status") List<String> txnStatus,
            @Param("search") String search,
            @Param("searchByField") String searchByField,
            PageRequest page
    );
}