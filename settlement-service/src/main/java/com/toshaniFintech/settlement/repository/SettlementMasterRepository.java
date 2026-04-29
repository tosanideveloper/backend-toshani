package com.toshaniFintech.settlement.repository;

import com.toshaniFintech.settlement.entity.SettlementMaster;
import com.toshaniFintech.settlement.enums.SettlementStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface SettlementMasterRepository extends JpaRepository<SettlementMaster, String> {

    Optional<SettlementMaster> findBySettlementUuid(String settlementUuid);

    List<SettlementMaster> findByUserUuid(String userUuid);

    List<SettlementMaster> findByStatus(SettlementStatus status);

    List<SettlementMaster> findByUserUuidAndStatus(String userUuid, SettlementStatus status);

    List<SettlementMaster> findBySettlementDateBetween(LocalDate from, LocalDate to);
}