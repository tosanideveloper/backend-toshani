package com.toshaniFintech.settlement.enums;

/**
 * Status of the bank-side settlement for a wallet transaction.
 * DISPUTE indicates a mismatch between expected and actual settlement received from bank.
 */
public enum BankSettlementStatus {
    SUCCESS,
    PENDING,
    DISPUTE
}