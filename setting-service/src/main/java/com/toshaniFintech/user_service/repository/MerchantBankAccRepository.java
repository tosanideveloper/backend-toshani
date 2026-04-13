package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.MerchantBankAccEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantBankAccRepository extends JpaRepository<MerchantBankAccEntity,String> {
}
