package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.UpiLiteChargeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

public interface UpiLiteChargeRepository extends JpaRepository<UpiLiteChargeEntity, String> {

    @Query("SELECT u FROM UpiLiteChargeEntity u " +
            "WHERE (:minAmount IS NULL OR u.minAmount >= :minAmount) " +
            "AND (:maxAmount IS NULL OR u.maxAmount <= :maxAmount) " +
            "AND (:chargeType IS NULL OR u.chargeType = :chargeType) " +
            "AND (:search IS NULL OR :search = '' " +
            " OR (:searchByField = 'minAmount' AND CAST(u.minAmount as string) LIKE CONCAT('%', :search, '%')) " +
            " OR (:searchByField = 'maxAmount' AND CAST(u.maxAmount as string) LIKE CONCAT('%', :search, '%')) " +
            " OR (:searchByField = 'chargeType' AND LOWER(u.chargeType) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            " OR (:searchByField = 'charge' AND CAST(u.charge as string) LIKE CONCAT('%', :search, '%')) )")
    Page<UpiLiteChargeEntity> fetchAll(
            @Param("minAmount") Double minAmount,
            @Param("maxAmount") Double maxAmount,
            @Param("chargeType") String chargeType,
            @Param("search") String search,
            @Param("searchByField") String searchByField,
            PageRequest pageRequest
    );
}