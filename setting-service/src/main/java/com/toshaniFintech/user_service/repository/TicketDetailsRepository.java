package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.TicketDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketDetailsRepository extends JpaRepository<TicketDetailsEntity, String> {
}
