package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.HierarchyMasterEntity;
import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HierarchyMasterRepository extends JpaRepository<HierarchyMasterEntity, Long> {

    Optional<HierarchyMasterEntity> findByHirarchyUuid(String uuid);

    @Query("""
        SELECT h FROM HierarchyMasterEntity h
        WHERE (:hirarchyStatus IS NULL OR c.hirarchyStatus = :hirarchyStatus)
        AND (:hirarchyName IS NULL OR LOWER(h.hirarchyName) LIKE LOWER(CONCAT('%', :hirarchyName, '%')))
        AND (
            :search IS NULL OR :search = '' OR
            (:searchByField = 'hirarchyName' AND LOWER(h.hirarchyName) LIKE LOWER(CONCAT('%', :search, '%')))
        )
    """)
    Page<HierarchyMasterEntity> fetchHierarchy(
            @Param("hirarchyName") String hirarchyName,
            @Param("hirarchyStatus") String hirarchyStatus,
            @Param("search") String search,
            @Param("searchByField") String searchByField,
            PageRequest page
    );
}
