package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.ApisServicesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApisServicesRepository extends JpaRepository<ApisServicesEntity, String> {


}
