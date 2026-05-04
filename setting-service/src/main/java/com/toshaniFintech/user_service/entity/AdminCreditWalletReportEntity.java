package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name=" th_admin_credit_wallet_report")
public class AdminCreditWalletReportEntity extends BaseEntity {
    @Column(name = "txn_date")
    private String txnDate;

    @Column(name = "txn_id")
    private String txnId;

    @Column(name = "api_name")
    private String apiName;

    @Column(name = "opening_balance")
    private String openingBalance;

    @Column(name = "credit_debit")
    private String creditDebit;

    @Column(name = "closing_balance")
    private String closingBalance;

    @Column(name = "key")
    private String key;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "txn_details")
    private String txnDetails;

    public String getTxnDate() {
        return txnDate;
    }

    public void setTxnDate(String txnDate) {
        this.txnDate = txnDate;
    }

    public String getTxnId() {
        return txnId;
    }

    public void setTxnId(String txnId) {
        this.txnId = txnId;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(String openingBalance) {
        this.openingBalance = openingBalance;
    }

    public String getCreditDebit() {
        return creditDebit;
    }

    public void setCreditDebit(String creditDebit) {
        this.creditDebit = creditDebit;
    }

    public String getClosingBalance() {
        return closingBalance;
    }

    public void setClosingBalance(String closingBalance) {
        this.closingBalance = closingBalance;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getTxnDetails() {
        return txnDetails;
    }

    public void setTxnDetails(String txnDetails) {
        this.txnDetails = txnDetails;
    }

}
