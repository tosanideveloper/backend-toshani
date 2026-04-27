package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.DmtChargeCommissionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DmtChargeCommissionRepository extends JpaRepository<DmtChargeCommissionEntity, String> {

    @Query("SELECT c FROM DmtChargeCommissionEntity c " +
            "WHERE (:search IS NULL OR :search = '' " +
            "   OR (:searchByField = 'minAmount' AND CAST(c.minAmount as string) LIKE CONCAT('%', :search, '%')) " +
            "   OR (:searchByField = 'maxAmount' AND CAST(c.maxAmount as string) LIKE CONCAT('%', :search, '%')) " +
            "   OR (:searchByField = 'commType' AND LOWER(c.commType) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'comm' AND CAST(c.comm as string) LIKE CONCAT('%', :search, '%')) )")
    Page<DmtChargeCommissionEntity> fetchDmtChargeCommission(
            @Param("search") String search,
            @Param("searchByField") String searchByField,
            PageRequest pageRequest
    );
}
