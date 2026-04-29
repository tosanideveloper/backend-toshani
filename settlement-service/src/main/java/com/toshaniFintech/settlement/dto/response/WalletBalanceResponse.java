package com.toshaniFintech.settlement.dto.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class WalletBalanceResponse {

    private String userUuid;

    // Total wallet balance = sum of all credits - sum of all debits
    private BigDecimal walletBalance;

    // Amount available for cashout: realtime_settlement=true OR eligible_settlement_date <= today
    private BigDecimal eligibleCashoutBalance;
}