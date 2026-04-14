package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.ApiAllMerchantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ApiAllMerchantRepository extends JpaRepository<ApiAllMerchantEntity, String> {
}

