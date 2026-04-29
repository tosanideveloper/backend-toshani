package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.Aeps1AadharPayCommissionEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Aeps1AadharPayCommissionRepository extends JpaRepository<Aeps1AadharPayCommissionEntity, String> {
    @Query("SELECT p FROM Aeps1AadharPayCommissionEntity p " +
            "WHERE (:chargeType IS NULL OR p.chargeType IN :chargeType) " +
            "AND (:search IS NULL OR :search = '' " +
            "   OR (:searchByField = 'chargeType' AND LOWER(p.chargeType) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            ")")
    Page<Aeps1AadharPayCommissionEntity> fetchAll(
            @Param("chargeType") List<String> chargeType,
            @Param("search") String search,
            @Param("searchByField") String searchByField,
            PageRequest pageRequest
    );
}
