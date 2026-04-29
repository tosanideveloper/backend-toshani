package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.ClientMasterEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientMasterRepository extends JpaRepository<ClientMasterEntity, Long> {
    Optional<ClientMasterEntity> findByClientUuid(String clientUuid);

    @Query("SELECT c FROM ClientMasterEntity c " +
            "WHERE (:clientName IS NULL OR LOWER(c.clientName) LIKE LOWER(CONCAT('%', :clientName, '%'))) " +
            "AND (:clientStatus IS NULL OR c.clientStatus = :clientStatus)")
    Page<ClientMasterEntity> fetchClients(
            @Param("clientName") String clientName,
            @Param("clientStatus") String clientStatus,
            PageRequest page
    );
}