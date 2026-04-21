package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.PayoutReportEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PayoutReportRepository extends JpaRepository<PayoutReportEntity, String> {

    @Query("SELECT p FROM PayoutReportEntity p " +
            "WHERE p.transactionDate BETWEEN :startDate AND :endDate " +
            "AND (:transactionId IS NULL OR p.transactionId IN :transactionId) " +
            "AND (:orderId IS NULL OR p.orderId IN :orderId) " +
            "AND (:apiTransactionId IS NULL OR p.apiTransactionId IN :apiTransactionId) " +
            "AND (:accountNumber IS NULL OR p.accountNumber IN :accountNumber) " +
            "AND (:ifsc IS NULL OR p.ifsc IN :ifsc) " +
            "AND (:bank IS NULL OR p.bank IN :bank) " +
            "AND (:utr IS NULL OR p.utr IN :utr) " +
            "AND (:type IS NULL OR p.type IN :type) " +
            "AND (:status IS NULL OR p.status IN :status) " +
            "AND (:apiName IS NULL OR p.apiName IN :apiName) " +
            "AND (:search IS NULL OR :search = '' " +
            "   OR (:searchByField = 'transactionId' AND LOWER(p.transactionId) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'orderId' AND LOWER(p.orderId) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'apiTransactionId' AND LOWER(p.apiTransactionId) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'partnerDetails' AND LOWER(p.partnerDetails) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'accountNumber' AND LOWER(p.accountNumber) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'ifsc' AND LOWER(p.ifsc) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'bank' AND LOWER(p.bank) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'utr' AND LOWER(p.utr) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'type' AND LOWER(p.type) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'status' AND LOWER(p.status) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'apiName' AND LOWER(p.apiName) LIKE LOWER(CONCAT('%', :search, '%'))) )")
    Page<PayoutReportEntity> fetchPayoutReport(
            @Param("startDate") String startDate,
            @Param("endDate") String endDate,
            @Param("transactionId") List<String> transactionId,
            @Param("orderId") List<String> orderId,
            @Param("apiTransactionId") List<String> apiTransactionId,
            @Param("accountNumber") List<String> accountNumber,
            @Param("ifsc") List<String> ifsc,
            @Param("bank") List<String> bank,
            @Param("utr") List<String> utr,
            @Param("type") List<String> type,
            @Param("status") List<String> status,
            @Param("apiName") List<String> apiName,
            @Param("search") String search,
            @Param("searchByField") String searchByField,
            PageRequest pageRequest
    );
}