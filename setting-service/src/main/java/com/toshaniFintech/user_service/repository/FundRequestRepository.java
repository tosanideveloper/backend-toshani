package com.toshaniFintech.user_service.repository;

import com.toshaniFintech.user_service.entity.FundRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FundRequestRepository extends JpaRepository<FundRequestEntity, String> {
        Optional<FundRequestEntity> findByRequestId(String RequestId);

    }
