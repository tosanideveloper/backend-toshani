package com.toshaniFintech.settlement.dto.request;

import com.toshaniFintech.settlement.enums.SettlementStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateSettlementRequest {

    @NotNull(message = "Status is mandatory")
    private SettlementStatus status;

    // Bank RRN populated when bank confirms the transfer
    private String rrnBank;

    private String remarks;
}