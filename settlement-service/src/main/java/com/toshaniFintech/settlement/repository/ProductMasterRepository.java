package com.toshaniFintech.settlement.repository;

import com.toshaniFintech.settlement.entity.ProductMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductMasterRepository extends JpaRepository<ProductMaster, String> {

    Optional<ProductMaster> findByProductUuid(String productUuid);

    Optional<ProductMaster> findByProductNameIgnoreCase(String productName);

    boolean existsByProductNameIgnoreCase(String productName);
}