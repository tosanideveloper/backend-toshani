package com.toshaniFintech.settlement.repository;

import com.toshaniFintech.settlement.entity.WalletMaster;
import com.toshaniFintech.settlement.enums.WalletTransactionRefType;
import com.toshaniFintech.settlement.enums.WalletTransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface WalletMasterRepository extends JpaRepository<WalletMaster, String> {

    Optional<WalletMaster> findByWalletUuid(String walletUuid);

    Optional<WalletMaster> findByWalletTransactionId(String walletTransactionId);

    List<WalletMaster> findByUserUuid(String userUuid);

    List<WalletMaster> findByUserUuidAndTransactionType(String userUuid, WalletTransactionType type);

    List<WalletMaster> findByUserUuidAndTransactionRefType(String userUuid, WalletTransactionRefType refType);

    // Sum all settlement_amount for a user to compute current wallet balance
    @Query("SELECT COALESCE(SUM(CASE WHEN w.transactionType = 'CREDIT' THEN w.transactionAmount ELSE -w.transactionAmount END), 0) " +
            "FROM WalletMaster w WHERE w.userUuid = :userUuid")
    BigDecimal calculateWalletBalance(@Param("userUuid") String userUuid);

    // Eligible cashout = sum of settlement_amount where realtime_settlement=true or eligible_settlement_date <= today
    @Query("SELECT COALESCE(SUM(w.settlementAmount), 0) FROM WalletMaster w " +
            "WHERE w.userUuid = :userUuid AND w.transactionType = 'CREDIT' " +
            "AND (w.realtimeSettlement = true OR w.eligibleSettlementDate <= :today)")
    BigDecimal calculateEligibleCashoutBalance(@Param("userUuid") String userUuid, @Param("today") LocalDate today);

    List<WalletMaster> findByUserUuidAndTransactionDateBetween(String userUuid, LocalDate from, LocalDate to);
}