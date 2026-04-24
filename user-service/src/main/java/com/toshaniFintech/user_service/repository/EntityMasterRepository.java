package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.EntityMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityMasterRepository extends JpaRepository<EntityMasterEntity, Long> {

}
