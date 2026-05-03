package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="th_hold_balance_log_report")
public class HoldBalanceLogReportEntity extends BaseEntity {
    @Column(name="txn_date")
    private String txnDate;

    @Column(name="partner_details")
    private String partnerDetails;

    @Column(name="partner_id")
    private String partnerId;

    @Column(name="debit_hold_balance_before")
    private String debitHoldBalanceBefore;

    @Column(name="debit_hold_balance_after")
    private String debitHoldBalanceAfter;

    @Column(name="credit_hold_balance_before")
    private String creditHoldBalanceBefore;

    @Column(name="credit_hold_balance_after")
    private String creditHoldBalanceAfter;

    public String getTxnDate() {
        return txnDate;
    }

    public void setTxnDate(String txnDate) {
        this.txnDate = txnDate;
    }

    public String getPartnerDetails() {
        return partnerDetails;
    }

    public void setPartnerDetails(String partnerDetails) {
        this.partnerDetails = partnerDetails;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getDebitHoldBalanceBefore() {

        return debitHoldBalanceBefore;
    }
    public void setDebitHoldBalanceBefore(String debitHoldBalanceBefore) {
        this.debitHoldBalanceBefore = debitHoldBalanceBefore;
    }

    public String getDebitHoldBalanceAfter() {
        return debitHoldBalanceAfter;
    }
    public void setDebitHoldBalanceAfter(String debitHoldBalanceAfter) {
        this.debitHoldBalanceAfter = debitHoldBalanceAfter;
    }

    public String getCreditHoldBalanceBefore() {
        return creditHoldBalanceBefore;
    }

    public void setCreditHoldBalanceBefore(String creditHoldBalanceBefore) {
        this.creditHoldBalanceBefore = creditHoldBalanceBefore;
    }

    public String getCreditHoldBalanceAfter() {
        return creditHoldBalanceAfter;
    }

    public void setCreditHoldBalanceAfter(String creditHoldBalanceAfter) {
        this.creditHoldBalanceAfter = creditHoldBalanceAfter;
    }
}
