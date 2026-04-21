package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.CardPayChargeEntity;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

public interface CardPayChargeRepository extends JpaRepository<CardPayChargeEntity, String> {

    @Query("SELECT c FROM CardPayChargeEntity c " +
            "WHERE (:minAmount IS NULL OR c.minAmount >= :minAmount) " +
            "AND (:maxAmount IS NULL OR c.maxAmount <= :maxAmount) " +
            "AND (:chargeType IS NULL OR c.chargeType = :chargeType) " +
            "AND (:search IS NULL OR :search = '' " +
            " OR (:searchByField = 'minAmount' AND CAST(c.minAmount as string) LIKE CONCAT('%', :search, '%')) " +
            " OR (:searchByField = 'maxAmount' AND CAST(c.maxAmount as string) LIKE CONCAT('%', :search, '%')) " +
            " OR (:searchByField = 'chargeType' AND LOWER(c.chargeType) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            " OR (:searchByField = 'charge' AND CAST(c.charge as string) LIKE CONCAT('%', :search, '%')) )")
    Page<CardPayChargeEntity> fetchAll(
            @Param("minAmount") Double minAmount,
            @Param("maxAmount") Double maxAmount,
            @Param("chargeType") String chargeType,
            @Param("search") String search,
            @Param("searchByField") String searchByField,
            PageRequest pageRequest
    );
}