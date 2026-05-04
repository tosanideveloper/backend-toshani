package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.Aeps3CommissionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface Aeps3CommissionRepository extends JpaRepository<Aeps3CommissionEntity, String> {
    @Query("SELECT p FROM Aeps3CommissionEntity p " +
            "WHERE (:transactionType IS NULL OR p.transactionType IN :transactionType) " +
            "AND (:commissionType IS NULL OR p.commissionType = :commissionType) " +
            "AND p.createDate BETWEEN :startDate AND :endDate " +
            "AND (:search IS NULL OR :search = '' " +
            "   OR (:searchByField = 'transactionType' AND LOWER(p.transactionType) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'commissionType' AND LOWER(p.commissionType) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            ")")
    Page<Aeps3CommissionEntity> fetchAllAeps3(
            @Param("transactionType") String transactionType,
            @Param("commissionType") List<String> commissionType,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("search") String search,
            @Param("searchByField") String searchByField,
            PageRequest pageRequest
    );
}
