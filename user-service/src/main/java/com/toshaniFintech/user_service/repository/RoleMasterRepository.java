package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.RoleMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMasterRepository extends JpaRepository<RoleMasterEntity, Long> {

}
