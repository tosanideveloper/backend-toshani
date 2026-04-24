package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.MerchantUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantUserRepository extends JpaRepository<MerchantUserEntity, Long> {

}
