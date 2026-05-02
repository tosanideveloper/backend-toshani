package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class ReconciliationReportResponseDTO {

    private LocalDate txnDate;
    private String debitWalletOpening;
    private String debitWalletClosing;
    private String creditTotal;
    private String debitTotal;
    private String actions;
}
