package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.Aeps3ReportEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Aeps3ReportRepository extends JpaRepository<Aeps3ReportEntity, String> {

    @Query("SELECT a FROM Aeps3ReportEntity a " +
            "WHERE a.txnDate BETWEEN :startDate AND :endDate " +
            "AND (:orderId IS NULL OR a.orderId IN :orderId) " +
            "AND (:txnId IS NULL OR a.txnId IN :txnId) " +
            "AND (:txnType IS NULL OR a.txnType IN :txnType) " +
            "AND (:txnStatus IS NULL OR a.txnStatus IN :txnStatus) " +
            "AND ( :search IS NULL OR :search = '' " +
            "   OR (:searchByField = 'txnId' AND LOWER(a.txnId) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'orderId' AND LOWER(a.orderId) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'bankName' AND LOWER(a.bankName) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'aadhaarNo' AND LOWER(a.aadhaarNo) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'merchantCode' AND LOWER(a.merchantCode) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'txnType' AND LOWER(a.txnType) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'txnStatus' AND LOWER(a.txnStatus) LIKE LOWER(CONCAT('%', :search, '%'))) )")
    Page<Aeps3ReportEntity> fetchAeps3Report(
            @Param("startDate") String startDate,
            @Param("endDate") String endDate,
            @Param("orderId") List<String> orderId,
            @Param("txnId") List<String> txnId,
            @Param("txnType") List<String> txnType,
            @Param("txnStatus") List<String> txnStatus,
            @Param("search") String search,
            @Param("searchByField") String searchByField,
            PageRequest page
    );
}
