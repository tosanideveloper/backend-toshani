package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.SiteSettingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteSettingRepository extends JpaRepository<SiteSettingEntity,String> {
}
