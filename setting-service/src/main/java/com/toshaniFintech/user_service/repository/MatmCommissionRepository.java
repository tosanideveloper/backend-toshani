package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.MatmCommissionEntity;
import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface MatmCommissionRepository extends JpaRepository<MatmCommissionEntity, String> {

//    @Query("SELECT p FROM MatmCommissionEntity p " +
//            "WHERE (:paymentMode IS NULL OR p.paymentMode IN :paymentMode) " +
//            "AND (:chargeType IS NULL OR p.chargeType IN :chargeType) " +
//            "AND (:minAmount IS NULL OR p.minAmount >= :minAmount) " +
//            "AND (:maxAmount IS NULL OR p.maxAmount <= :maxAmount) " +
//            "AND (:search IS NULL OR :search = '' " +
//            "   OR (:searchByField = 'minAmount' AND CAST(p.minAmount as string) LIKE CONCAT('%', :search, '%')) " +
//            "   OR (:searchByField = 'maxAmount' AND CAST(p.maxAmount as string) LIKE CONCAT('%', :search, '%')) " +
//            "   OR (:searchByField = 'paymentMode' AND LOWER(p.paymentMode) LIKE LOWER(CONCAT('%', :search, '%'))) " +
//            "   OR (:searchByField = 'chargeType' AND LOWER(p.chargeType) LIKE LOWER(CONCAT('%', :search, '%'))) " +
//            "   OR (:searchByField = 'charge' AND CAST(p.charge as string) LIKE CONCAT('%', :search, '%')) )")

    Page<MatmCommissionEntity> fetchAll(
            @Param("minAmount") Double minAmount,
            @Param("maxAmount") Double maxAmount,
            @Param("commType") java.util.List<String> commType,
            @Param("search") String search,
            @Param("searchByField") String searchByField,
            PageRequest pageRequest
    );
}
