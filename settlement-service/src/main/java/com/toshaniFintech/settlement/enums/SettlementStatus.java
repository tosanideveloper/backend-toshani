package com.toshaniFintech.settlement.enums;

/**
 * Lifecycle states of a settlement record as defined in the settlement_master design.
 * REVERSED is used when a successful settlement is rolled back.
 */
public enum SettlementStatus {
    REQUESTED,
    PENDING,
    SUCCESS,
    FAILURE,
    REVERSED
}