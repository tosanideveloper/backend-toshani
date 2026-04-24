package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.CreditCardChargeCommissionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardChargeCommissionRepository extends JpaRepository<CreditCardChargeCommissionEntity, String> {

    @Query("SELECT c FROM CreditCardChargeCommissionEntity c " +
            "WHERE (:search IS NULL OR :search = '' " +
            "   OR (:searchByField = 'minAmount' AND CAST(c.minAmount as string) LIKE CONCAT('%', :search, '%')) " +
            "   OR (:searchByField = 'maxAmount' AND CAST(c.maxAmount as string) LIKE CONCAT('%', :search, '%')) " +
            "   OR (:searchByField = 'chargeType' AND LOWER(c.chargeType) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'charge' AND CAST(c.charge as string) LIKE CONCAT('%', :search, '%')) )")
    Page<CreditCardChargeCommissionEntity> fetchCreditCardChargeCommission(
            @Param("search") String search,
            @Param("searchByField") String searchByField,
            PageRequest pageRequest
    );
}