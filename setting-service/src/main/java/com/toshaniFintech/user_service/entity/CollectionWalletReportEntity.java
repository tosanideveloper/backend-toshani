package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="th_collection_wallet_report")
public class CollectionWalletReportEntity extends BaseEntity {
    @Column(name = "txn_date")
    private String txnDate;

    @Column(name = "txn_id")
    private String txnId;

    @Column(name = "api_user_details")
    private String apiUserDetails;

    @Column(name = "opening_balance")
    private String openingBalance;

    @Column(name = "credit_debit")
    private String creditDebit;

    @Column(name = "closing_balance")
    private String closingBalance;

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

    public String getApiUserDetails() {
        return apiUserDetails;
    }

    public void setApiUserDetails(String apiUserDetails) {
        this.apiUserDetails = apiUserDetails;
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

    public String getTxnDetails() {
        return txnDetails;
    }

    public void setTxnDetails(String txnDetails) {
        this.txnDetails = txnDetails;
    }
}
