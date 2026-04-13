package com.toshaniFintech.user_service.model;

import lombok.Data;

import java.util.Date;

@Data
public class ReconciliationReportModel {
    private Date txnDate;
    private String debitWalletOpening;
    private String debitWalletClosing;
    private String creditTotal;
    private String debitTotal;
    private String actions;
}
