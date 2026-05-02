package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.HdfcVirtualLogEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HdfcVirtualLogRepository extends JpaRepository<HdfcVirtualLogEntity,String> {
    @Query("SELECT a FROM HdfcVirtualLogEntity a " +
            "WHERE a.txnDate BETWEEN :startDate AND :endDate " +
            "AND (:userId IS NULL OR a.userId IN :userId) " +
            "AND (:userName IS NULL OR a.userName IN :userName) " +
            "AND (:accountNumber IS NULL OR a.accountNumber IN :accountNumber) " +
            "AND (:status IS NULL OR a.status IN :status) " +
            "AND ( :search IS NULL OR :search = '' " +
            "   OR (:searchByField = 'userId' AND LOWER(a.userId) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'userName' AND LOWER(a.userName) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'userReferenceNumber' AND LOWER(a.userReferenceNumber) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'virtualAccount' AND LOWER(a.virtualAccount) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'accountNumber' AND LOWER(a.accountNumber) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'status' AND LOWER(a.status) LIKE LOWER(CONCAT('%', :search, '%'))) )")
    Page<HdfcVirtualLogEntity> fetchHdfcVirtualLog(
            @Param("startDate") String startDate,
            @Param("endDate") String endDate,
            @Param("userId") List<String> userId,
            @Param("userName") List<String> userName,
            @Param("accountNumber") List<String> accountNumber,
            @Param("status") List<String> status,
            @Param("search") String search,
            @Param("searchByField") String searchByField,
            PageRequest page
    );

}
