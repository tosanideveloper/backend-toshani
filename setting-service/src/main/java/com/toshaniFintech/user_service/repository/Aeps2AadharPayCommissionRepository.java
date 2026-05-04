package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.Aeps2AadharPayCommissionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface Aeps2AadharPayCommissionRepository
        extends JpaRepository<Aeps2AadharPayCommissionEntity, String> {

    @Query("SELECT p FROM Aeps2AadharPayCommissionEntity p " +
            "WHERE (:commType IS NULL OR p.commType IN :commType) " +
            "AND p.createDate BETWEEN :startDate AND :endDate " +
            "AND (:search IS NULL OR :search = '' " +
            "   OR (:searchByField = 'commType' AND LOWER(p.commType) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'rrn' AND LOWER(p.rrn) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            ")")
    Page<Aeps2AadharPayCommissionEntity> fetchAllAeps2AadharPay(
            @Param("commType") List<String> commType,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("search") String search,
            @Param("searchByField") String searchByField,
            PageRequest pageRequest
    );
}