package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.PaytmPosChargeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaytmPosChargeRepository extends JpaRepository<PaytmPosChargeEntity, String> {

    @Query("SELECT p FROM PaytmPosChargeEntity p " +
            "WHERE (:paymentMode IS NULL OR p.paymentMode IN :paymentMode) " +
            "AND (:chargeType IS NULL OR p.chargeType IN :chargeType) " +
            "AND (:search IS NULL OR :search = '' " +
            "   OR (:searchByField = 'paymentMode' AND LOWER(p.paymentMode) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "   OR (:searchByField = 'chargeType' AND LOWER(p.chargeType) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            ")")

    Page<PaytmPosChargeEntity> fetchAll(
            @Param("paymentMode") List<String> paymentMode,
            @Param("chargeType") List<String> chargeType,
            @Param("search") String search,
            @Param("searchByField") String searchByField,
            PageRequest pageRequest
    );
}