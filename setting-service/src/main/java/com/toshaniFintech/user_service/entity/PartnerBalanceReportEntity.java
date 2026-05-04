package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="th_partner_balance_report")
public class PartnerBalanceReportEntity extends BaseEntity {
    @Column(name="txn_date")
    private String txnDate;

    @Column(name="company_details")
    private String companyDetails;

    @Column(name="user_id")
    private String userId;

    @Column(name="user_type")
    private String userType;

    @Column(name="debit_balance")
    private String debitBalance;

    @Column(name="credit_balance")
    private String creditBalance;

    @Column(name="virtual_balance")
    private String virtualBalance;

    @Column(name="actual_balance")
    private String actualBalance;

    public String getTxnDate() {
        return txnDate;
    }

    public void setTxnDate(String txnDate) {
        this.txnDate = txnDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCompanyDetails() {
        return companyDetails;
    }

    public void setCompanyDetails(String companyDetails) {
        this.companyDetails = companyDetails;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getCreditBalance() {
        return creditBalance;
    }

    public void setCreditBalance(String creditBalance) {
        this.creditBalance = creditBalance;
    }


    public String getDebitBalance() {
        return debitBalance;
    }

    public void setDebitBalance(String debitBalance) {
        this.debitBalance = debitBalance;
    }

    public String getVirtualBalance() {
        return virtualBalance;
    }

    public void setVirtualBalance(String virtualBalance) {
        this.virtualBalance = virtualBalance;
    }

    public String getActualBalance() {
        return actualBalance;
    }

    public void setActualBalance(String actualBalance) {
        this.actualBalance = actualBalance;
    }
}
