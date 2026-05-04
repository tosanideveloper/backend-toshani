package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.Aeps2CommissionEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface Aeps2CommissionRepository extends JpaRepository<Aeps2CommissionEntity, String> {
    @Query("SELECT p FROM Aeps2CommissionEntity p " +
            "WHERE (:commType IS NULL OR p.commType IN :commType) " +
            "AND (:transactionType IS NULL OR p.transactionType = :transactionType) " +
            "AND p.createDate BETWEEN :startDate AND :endDate " +
            "AND (:search IS NULL OR :search = '' " +
            "   OR (:searchByField = 'commType' AND LOWER(p.commType) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'transactionType' AND LOWER(p.transactionType) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            ")")
    Page<Aeps2CommissionEntity> fetchAll(
            @Param("commType") List<String> commType,
            @Param("transactionType") String transactionType,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("search") String search,
            @Param("searchByField") String searchByField,
            Pageable pageable
    );
}
