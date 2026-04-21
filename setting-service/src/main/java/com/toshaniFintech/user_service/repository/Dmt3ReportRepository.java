package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.Dmt3ReportEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Dmt3ReportRepository extends JpaRepository<Dmt3ReportEntity, String> {

    @Query("SELECT d FROM Dmt3ReportEntity d " +
            "WHERE d.transactionDate BETWEEN :startDate AND :endDate " +
            "AND (:transactionId IS NULL OR d.transactionId IN :transactionId) " +
            "AND (:orderId IS NULL OR d.orderId IN :orderId) " +
            "AND (:accountNumber IS NULL OR d.accountNumber IN :accountNumber) " +
            "AND (:ifsc IS NULL OR d.ifsc IN :ifsc) " +
            "AND (:utr IS NULL OR d.utr IN :utr) " +
            "AND (:type IS NULL OR d.type IN :type) " +
            "AND (:status IS NULL OR d.status IN :status) " +
            "AND (:apiName IS NULL OR d.apiName IN :apiName) " +
            "AND (:search IS NULL OR :search = '' " +
            "   OR (:searchByField = 'transactionId' AND LOWER(d.transactionId) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'orderId' AND LOWER(d.orderId) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'apiUserDetails' AND LOWER(d.apiUserDetails) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'accountNumber' AND LOWER(d.accountNumber) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'ifsc' AND LOWER(d.ifsc) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'bank' AND LOWER(d.bank) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'utr' AND LOWER(d.utr) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'type' AND LOWER(d.type) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'status' AND LOWER(d.status) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'apiName' AND LOWER(d.apiName) LIKE LOWER(CONCAT('%', :search, '%'))) )")
    Page<Dmt3ReportEntity> fetchDmt3Report(
            @Param("startDate") String startDate,
            @Param("endDate") String endDate,
            @Param("transactionId") List<String> transactionId,
            @Param("orderId") List<String> orderId,
            @Param("accountNumber") List<String> accountNumber,
            @Param("ifsc") List<String> ifsc,
            @Param("utr") List<String> utr,
            @Param("type") List<String> type,
            @Param("status") List<String> status,
            @Param("apiName") List<String> apiName,
            @Param("search") String search,
            @Param("searchByField") String searchByField,
            PageRequest pageRequest
    );
}