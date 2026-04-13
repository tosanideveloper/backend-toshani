package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "th_reconciliation_report")
public class ReconciliationReportEntity extends BaseEntity {

    @Column(name = "start_date", nullable = false)
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "txn_date")
    private String txnDate;

    @Column(name = "debit_wallet_opening")
    private String debitWalletOpening;

    @Column(name = "debit_wallet_closing")
    private String debitWalletClosing;

    @Column(name = "credit_total")
    private String creditTotal;

    @Column(name = "debit_total")
    private String debitTotal;

    @Column(name = "action")
    private String action;

    public ReconciliationReportEntity(String startDate, String endDate, String txnDate, String debitWalletOpening, String debitWalletClosing, String creditTotal, String debitTotal, String action) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.txnDate = txnDate;
        this.debitWalletOpening = debitWalletOpening;
        this.debitWalletClosing = debitWalletClosing;
        this.creditTotal = creditTotal;
        this.debitTotal = debitTotal;
        this.action = action;
    }

    public ReconciliationReportEntity() {

    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getTxnDate() {
        return txnDate;
    }

    public void setTxnDate(String txnDate) {
        this.txnDate = txnDate;
    }

    public String getDebitWalletOpening() {
        return debitWalletOpening;
    }

    public void setDebitWalletOpening(String debitWalletOpening) {
        this.debitWalletOpening = debitWalletOpening;
    }

    public String getDebitWalletClosing() {
        return debitWalletClosing;
    }

    public void setDebitWalletClosing(String debitWalletClosing) {
        this.debitWalletClosing = debitWalletClosing;
    }

    public String getCreditTotal() {
        return creditTotal;
    }

    public void setCreditTotal(String creditTotal) {
        this.creditTotal = creditTotal;
    }

    public String getDebitTotal() {
        return debitTotal;
    }

    public void setDebitTotal(String debitTotal) {
        this.debitTotal = debitTotal;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
