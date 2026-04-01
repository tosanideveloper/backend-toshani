package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.SettingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SettingRepository extends JpaRepository<SettingEntity, String> {

    Optional<SettingEntity> findBySettingKey(String settingKey);
}