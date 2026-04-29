package com.toshaniFintech.settlement.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class GenerateBalanceHistoryRequest {

    // If null, generates for all users; if set, generates only for this user
    private String userUuid;

    @NotNull(message = "Date is mandatory")
    private LocalDate date;
}