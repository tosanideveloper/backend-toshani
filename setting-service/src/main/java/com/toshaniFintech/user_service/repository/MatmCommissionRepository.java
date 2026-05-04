package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.MatmCommissionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository

public interface MatmCommissionRepository extends JpaRepository<MatmCommissionEntity, String> {

    @Query("SELECT p FROM MatmCommissionEntity p " +
            "WHERE (:commType IS NULL OR p.commType IN :commType) " +
            "AND p.createDate BETWEEN :startDate AND :endDate " +
            "AND (:search IS NULL OR :search = '' " +
            "   OR (:searchByField = 'commType' AND LOWER(p.commType) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            ")")
    Page<MatmCommissionEntity> fetchAll(
            @Param("commType") java.util.List<String> commType,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("search") String search,
            @Param("searchByField") String searchByField,
            PageRequest pageRequest
    );
}
