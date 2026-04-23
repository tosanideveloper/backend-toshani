package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.ExpressUpiChargeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ExpressUpiChargeRepository extends JpaRepository<ExpressUpiChargeEntity, String> {

    @Query("SELECT e FROM ExpressUpiChargeEntity e " +
            "WHERE (:minAmount IS NULL OR e.minAmount >= :minAmount) " +
            "AND (:maxAmount IS NULL OR e.maxAmount <= :maxAmount) " +
            "AND (:chargeType IS NULL OR e.chargeType = :chargeType) " +
            "AND (:search IS NULL OR :search = '' " +
            " OR (:searchByField = 'minAmount' AND CAST(e.minAmount as string) LIKE CONCAT('%', :search, '%')) " +
            " OR (:searchByField = 'maxAmount' AND CAST(e.maxAmount as string) LIKE CONCAT('%', :search, '%')) " +
            " OR (:searchByField = 'chargeType' AND LOWER(e.chargeType) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            " OR (:searchByField = 'charge' AND CAST(e.charge as string) LIKE CONCAT('%', :search, '%')) )")
    Page<ExpressUpiChargeEntity> fetchAll(
            @Param("minAmount") Double minAmount,
            @Param("maxAmount") Double maxAmount,
            @Param("chargeType") String chargeType,
            @Param("search") String search,
            @Param("searchByField") String searchByField,
            PageRequest pageRequest
    );
}