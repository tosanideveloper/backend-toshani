package com.toshaniFintech.settlement.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import com.toshaniFintech.settlement.enums.SettlementRefType;
import com.toshaniFintech.settlement.enums.SettlementStatus;
import com.toshaniFintech.settlement.enums.SettlementTransactionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Represents a single settlement payout request from the platform to a merchant/user bank account.
 * settlement_uuid uniquely identifies each settlement for external tracking.
 */
@Getter
@Setter
@Entity
@Table(name = "th_settlement_master")
public class SettlementMaster extends BaseEntity {

    @Column(name = "settlement_uuid", nullable = false, unique = true)
    private String settlementUuid;

    // Reference to the originating transaction for this settlement
    @Column(name = "transaction_id")
    private String transactionId;

    // UUID of the user who owns this settlement
    @Column(name = "user_uuid", nullable = false)
    private String userUuid;

    // Bank Reference Number returned by the bank after payout
    @Column(name = "rrn_bank")
    private String rrnBank;

    // Client-side reference ID for reconciliation
    @Column(name = "client_ref_id")
    private String clientRefId;

    @Column(name = "transaction_amount", nullable = false, precision = 18, scale = 2)
    private BigDecimal transactionAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private SettlementStatus status;

    // Transfer mode: IMPS (instant) or NEFT (batch)
    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_ref_type")
    private SettlementRefType transactionRefType;

    // AUTO = triggered by cron; MANUAL = admin-initiated
    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type")
    private SettlementTransactionType transactionType;

    // UUID of the merchant's bank account (client bank account)
    @Column(name = "merchant_uuid")
    private String merchantUuid;

    // UUID of the user's bank account where settlement is sent
    @Column(name = "user_account_uuid")
    private String userAccountUuid;

    @Column(name = "settlement_date")
    private LocalDate settlementDate;
}