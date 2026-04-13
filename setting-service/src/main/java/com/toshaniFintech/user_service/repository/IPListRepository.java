package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.IPAddressesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPListRepository extends JpaRepository<IPAddressesEntity, String> {
}
