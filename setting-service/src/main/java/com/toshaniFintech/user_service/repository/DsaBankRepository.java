package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.DsaBankEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DsaBankRepository extends JpaRepository<DsaBankEntity, String> {
    Optional<DsaBankEntity> findByDsaBankName(String settingKey);
}
