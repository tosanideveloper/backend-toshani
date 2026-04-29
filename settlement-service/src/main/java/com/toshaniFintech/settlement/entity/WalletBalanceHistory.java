package com.toshaniFintech.settlement.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Daily snapshot of a user's wallet. One record per user per date.
 * Populated by the BOD/EOD cron job at start and end of each business day.
 * bod_balance = eod_balance of the previous day.
 */
@Getter
@Setter
@Entity
@Table(name = "th_wallet_balance_history",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_uuid", "date"}))
public class WalletBalanceHistory extends BaseEntity {

    @Column(name = "uuid", nullable = false, unique = true)
    private String uuid;

    @Column(name = "user_uuid", nullable = false)
    private String userUuid;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    // Balance at the start of the business day
    @Column(name = "bod_balance", precision = 18, scale = 2)
    private BigDecimal bodBalance;

    // Balance at the end of the business day
    @Column(name = "eod_balance", precision = 18, scale = 2)
    private BigDecimal eodBalance;

    @Column(name = "total_debit_amount", precision = 18, scale = 2)
    private BigDecimal totalDebitAmount;

    @Column(name = "total_credit_amount", precision = 18, scale = 2)
    private BigDecimal totalCreditAmount;

    // Eligible wallet balance (eligible_for_cashout) at start of day
    @Column(name = "eligible_bod", precision = 18, scale = 2)
    private BigDecimal eligibleBod;

    // Eligible wallet balance at end of day
    @Column(name = "eligible_eod", precision = 18, scale = 2)
    private BigDecimal eligibleEod;
}