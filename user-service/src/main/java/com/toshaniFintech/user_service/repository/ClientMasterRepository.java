package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.ClientMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientMasterRepository extends JpaRepository<ClientMasterEntity, Long> {

}
