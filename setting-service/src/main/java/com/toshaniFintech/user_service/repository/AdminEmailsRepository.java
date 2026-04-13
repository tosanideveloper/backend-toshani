package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.AdminEmailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminEmailsRepository extends JpaRepository<AdminEmailsEntity, String> {
}
