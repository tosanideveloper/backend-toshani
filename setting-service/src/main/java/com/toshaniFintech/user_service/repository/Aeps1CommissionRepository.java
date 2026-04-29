package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.Aeps1CommissionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository

public interface Aeps1CommissionRepository extends JpaRepository<Aeps1CommissionEntity, String> {
    @Query("SELECT p FROM Aeps1CommissionEntity p " + "WHERE (:commType IS NULL OR p.commType IN :commType) "
            + "AND (:search IS NULL OR :search = '' " + "   " +
            "OR (:searchByField = 'commType' AND LOWER(p.commType) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            ")")

    Page<Aeps1CommissionEntity> fetchAll(
            @Param("commType") List<String> commType,
            @Param("search") String search,
            @Param("searchByField") String searchByField, PageRequest pageRequest);
}
