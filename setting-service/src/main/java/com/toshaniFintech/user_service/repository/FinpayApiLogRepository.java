package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.FinpayApiLogEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinpayApiLogRepository extends JpaRepository<FinpayApiLogEntity, String> {

    @Query("SELECT a FROM FinpayApiLogEntity a " +
            "WHERE a.txnDate BETWEEN :startDate AND :endDate " +
            "AND (:partnerId IS NULL OR a.partnerId IN :partnerId) " +
            "AND ( :search IS NULL OR :search = '' " +
            "   OR (:searchByField = 'partnerId' AND LOWER(a.partnerId) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'partnerName' AND LOWER(a.partnerName) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'source' AND LOWER(a.source) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'url' AND LOWER(a.url) LIKE LOWER(CONCAT('%', :search, '%'))) )")
    Page<FinpayApiLogEntity> fetchFinpayApiLog(
            @Param("startDate") String startDate,
            @Param("endDate") String endDate,
            @Param("partnerId") List<String> txnId,
            @Param("search") String search,
            @Param("searchByField") String searchByField,
            PageRequest page
    );
}
