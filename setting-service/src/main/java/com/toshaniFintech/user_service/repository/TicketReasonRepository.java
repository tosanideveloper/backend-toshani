package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.TicketReasonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketReasonRepository extends JpaRepository<TicketReasonEntity, String> {
}
