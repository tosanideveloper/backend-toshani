package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.EntityMasterEntity;
import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntityMasterRepository extends JpaRepository<EntityMasterEntity, Long> {

    Optional<EntityMasterEntity> findByEntityUuid(String uuid);

    @Query("""
        SELECT e FROM EntityMasterEntity e
        WHERE (:entityName IS NULL OR LOWER(e.entityName) LIKE LOWER(CONCAT('%', :entityName, '%')))
       AND (
            :search IS NULL OR :search = '' OR
            (:searchByField = 'entityName' AND LOWER(e.entityName) LIKE LOWER(CONCAT('%', :search, '%')))
        )
    """)
    Page<EntityMasterEntity> fetchEntities(
            @Param("entityName") String entityName,
            @Param("search") String search,
            @Param("searchByField") String searchByField,
            PageRequest page
    );
}
