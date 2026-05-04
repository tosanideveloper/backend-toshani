package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.Aeps1ReportEntity;
import com.toshaniFintech.user_service.entity.Aeps2MerchantReportEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Aeps2MerchantReportRepository extends JpaRepository<Aeps2MerchantReportEntity, String>{

    @Query("SELECT a FROM Aeps2MerchantReportEntity a " +
            "WHERE a.txnDate BETWEEN :startDate AND :endDate " +
            "AND ( :search IS NULL OR :search = '' " +
            "   OR (:searchByField = 'partnerDetails' AND LOWER(a.partnerDetails) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'userName' AND LOWER(a.userName) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'merchantName' AND LOWER(a.merchantName) LIKE LOWER(CONCAT('%', :search, '%'))) )")
    Page<Aeps2MerchantReportEntity> fetchAeps2MerchantReport(
            @Param("startDate") String startDate,
            @Param("endDate") String endDate,
            @Param("search") String search,
            @Param("searchByField") String searchByField,
            PageRequest page
    );
}
