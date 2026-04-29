package com.toshaniFintech.settlement.repository;

import com.toshaniFintech.settlement.entity.WalletBalanceHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface WalletBalanceHistoryRepository extends JpaRepository<WalletBalanceHistory, String> {

    List<WalletBalanceHistory> findByUserUuidOrderByDateDesc(String userUuid);

    List<WalletBalanceHistory> findByDate(LocalDate date);

    Optional<WalletBalanceHistory> findByUserUuidAndDate(String userUuid, LocalDate date);

    List<WalletBalanceHistory> findByUserUuidAndDateBetweenOrderByDateAsc(String userUuid, LocalDate from, LocalDate to);
}