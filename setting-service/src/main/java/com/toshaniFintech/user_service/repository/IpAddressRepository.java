package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.IpAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IpAddressRepository extends JpaRepository<IpAddressEntity, Long> {

    Optional<IpAddressEntity> findByName(String name);

    Optional<IpAddressEntity> findByIpaddress(String ipaddress);
}