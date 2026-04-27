package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.PayoutChargeCommissionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PayoutChargeCommissionRepository extends JpaRepository<PayoutChargeCommissionEntity, String> {

    @Query("SELECT c FROM PayoutChargeCommissionEntity c " +
            "WHERE (:search IS NULL OR :search = '' " +
            "   OR (:searchByField = 'minAmount' AND CAST(c.minAmount as string) LIKE CONCAT('%', :search, '%')) " +
            "   OR (:searchByField = 'maxAmount' AND CAST(c.maxAmount as string) LIKE CONCAT('%', :search, '%')) " +
            "   OR (:searchByField = 'chargeType' AND LOWER(c.chargeType) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'charge' AND CAST(c.charge as string) LIKE CONCAT('%', :search, '%')) )")
    Page<PayoutChargeCommissionEntity> fetchPayoutChargeCommission(
            @Param("search") String search,
            @Param("searchByField") String searchByField,
            PageRequest pageRequest
    );
}
