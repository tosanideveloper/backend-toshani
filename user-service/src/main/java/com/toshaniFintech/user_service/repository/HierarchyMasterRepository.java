package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.HierarchyMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HierarchyMasterRepository extends JpaRepository<HierarchyMasterEntity, Long> {

}
