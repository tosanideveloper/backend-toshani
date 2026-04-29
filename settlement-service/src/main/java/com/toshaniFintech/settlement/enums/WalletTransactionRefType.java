package com.toshaniFintech.settlement.enums;

/**
 * Source product/service that generated the wallet transaction.
 * HOLD and WALLET_TRANSFER are internal operations, not product-based.
 */
public enum WalletTransactionRefType {
    AEPS,
    MATM,
    BBPS,
    SETTLEMENT,
    WALLET,
    POS,
    UPI,
    ADV_PAY_CHARGES,
    HOLD,
    WALLET_TRANSFER
}