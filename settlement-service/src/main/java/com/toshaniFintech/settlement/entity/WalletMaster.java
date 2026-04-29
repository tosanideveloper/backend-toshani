package com.toshaniFintech.settlement.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import com.toshaniFintech.settlement.enums.BankSettlementStatus;
import com.toshaniFintech.settlement.enums.WalletTransactionRefType;
import com.toshaniFintech.settlement.enums.WalletTransactionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Central ledger of all wallet movements. Every product transaction (AEPS, MATM, etc.)
 * creates a WalletMaster entry. The eligible_settlement_date is computed as
 * transaction_date + product.settlement_day at write time.
 */
@Getter
@Setter
@Entity
@Table(name = "th_wallet_master")
public class WalletMaster extends BaseEntity {

    @Column(name = "wallet_uuid", nullable = false, unique = true)
    private String walletUuid;

    @Column(name = "user_uuid", nullable = false)
    private String userUuid;

    // Gross transaction amount before charges/taxes
    @Column(name = "transaction_amount", nullable = false, precision = 18, scale = 2)
    private BigDecimal transactionAmount;

    // Internal wallet transaction reference ID
    @Column(name = "wallet_transaction_id", unique = true)
    private String walletTransactionId;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type", nullable = false)
    private WalletTransactionType transactionType;

    // ID of the originating product transaction (e.g., AEPS txn ID)
    @Column(name = "transaction_ref_id")
    private String transactionRefId;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_ref_type")
    private WalletTransactionRefType transactionRefType;

    @Column(name = "status")
    private String status;

    // Amount after deducting GST, TDS, service charges
    @Column(name = "settlement_amount", precision = 18, scale = 2)
    private BigDecimal settlementAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "bank_settlement_status")
    private BankSettlementStatus bankSettlementStatus;

    // realtime_settlement = true means eligible_settlement_date equals transaction_date
    @Column(name = "realtime_settlement")
    private Boolean realtimeSettlement;

    @Column(name = "transaction_date")
    private LocalDate transactionDate;

    // Computed: transaction_date + product.settlement_day
    @Column(name = "eligible_settlement_date")
    private LocalDate eligibleSettlementDate;

    // Tracks if admin manually overrode the eligible_settlement_date
    @Column(name = "eligible_settlement_date_updated")
    private LocalDate eligibleSettlementDateUpdated;

    @Column(name = "gst", precision = 18, scale = 4)
    private BigDecimal gst;

    @Column(name = "cgst", precision = 18, scale = 4)
    private BigDecimal cgst;

    @Column(name = "sgst", precision = 18, scale = 4)
    private BigDecimal sgst;

    @Column(name = "tds", precision = 18, scale = 4)
    private BigDecimal tds;
}