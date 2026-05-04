package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.RemittanceChargeCommissionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RemittanceChargeCommissionRepository extends JpaRepository<RemittanceChargeCommissionEntity, String> {

    @Query("SELECT c FROM RemittanceChargeCommissionEntity c " +
            "WHERE (:search IS NULL OR :search = '' " +
            "   OR (:searchByField = 'chargeType' AND CAST(c.chargeType as string) LIKE CONCAT('%', :search, '%')) " +
            "   OR (:searchByField = 'charge' AND CAST(c.charge as string) LIKE CONCAT('%', :search, '%')) )")
    Page<RemittanceChargeCommissionEntity> fetchRemittanceChargeCommission(
            @Param("search") String search,
            @Param("searchByField") String searchByField,
            PageRequest pageRequest
    );
}
