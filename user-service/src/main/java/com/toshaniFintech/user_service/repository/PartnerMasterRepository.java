package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.PartnerMasterEntity;
import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartnerMasterRepository extends JpaRepository<PartnerMasterEntity, Long> {
    Optional<PartnerMasterEntity> findByPartnerUuid(String partnerUuid);
    @Query("""
        SELECT p FROM PartnerMasterEntity p
        WHERE (:partnerType IS NULL OR c.partnerType = :partnerType)
        AND (:partnerName IS NULL OR LOWER(p.partnerName) LIKE LOWER(CONCAT('%', :partnerName, '%')))
        AND (:partnerStatus IS NULL OR p.partnerStatus = :partnerStatus)
        AND (
            :search IS NULL OR :search = '' OR
            (:searchByField = 'partnerName' AND LOWER(p.partnerName) LIKE LOWER(CONCAT('%', :search, '%'))) OR
            (:searchByField = 'partnerType' AND LOWER(p.partnerType) LIKE LOWER(CONCAT('%', :search, '%')))
        )
    """)
    Page<PartnerMasterEntity> fetchPartners(
            @Param("partnerName") String partnerName,
            @Param("partnerType") String partnerType,
            @Param("partnerStatus") String partnerStatus,
            @Param("search") String search,
            @Param("searchByField") String searchByField,
            PageRequest page
    );
}
