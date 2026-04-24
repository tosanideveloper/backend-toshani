package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.UpiCollectReportEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UpiCollectReportRepository extends JpaRepository<UpiCollectReportEntity, String> {

    @Query("SELECT u FROM UpiCollectReportEntity u " +
            "WHERE u.date BETWEEN :startDate AND :endDate " +
            "AND (:requestId IS NULL OR u.requestId IN :requestId) " +
            "AND (:type IS NULL OR u.type IN :type) " +
            "AND (:status IS NULL OR u.status IN :status) " +
            "AND (:apiName IS NULL OR u.apiName IN :apiName) " +
            "AND (:search IS NULL OR :search = '' " +
            "   OR (:searchByField = 'requestId' AND LOWER(u.requestId) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'apiUserDetail' AND LOWER(u.apiUserDetail) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'type' AND LOWER(u.type) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'status' AND LOWER(u.status) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'apiName' AND LOWER(u.apiName) LIKE LOWER(CONCAT('%', :search, '%'))) )")
    Page<UpiCollectReportEntity> fetchUpiCollectReport(
            @Param("startDate") String startDate,
            @Param("endDate") String endDate,
            @Param("requestId") List<String> requestId,
            @Param("type") List<String> type,
            @Param("status") List<String> status,
            @Param("apiName") List<String> apiName,
            @Param("search") String search,
            @Param("searchByField") String searchByField,
            PageRequest pageRequest
    );
}