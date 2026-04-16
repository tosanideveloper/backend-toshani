package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.AEPS2MerchantReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AEPS2MerchantReportRepository extends JpaRepository<AEPS2MerchantReportEntity, String>{
}
