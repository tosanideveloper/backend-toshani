package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.RolePrivilegeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePrivilegeRepository extends JpaRepository<RolePrivilegeEntity, Long> {

}
