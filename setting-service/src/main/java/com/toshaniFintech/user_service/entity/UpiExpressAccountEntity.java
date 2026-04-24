package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "th_upiexpress_account_limit")
public class UpiExpressAccountEntity extends BaseEntity {

    @Column(name = "account_no")
    private String accountNo;

    @Column(name = "limit_amount")
    private Double limitAmount;

    @Column(name = "txn_date")
    private String txnDate;

    public UpiExpressAccountEntity(String accountNo, Double limitAmount, String txnDate) {
        this.accountNo = accountNo;
        this.limitAmount = limitAmount;
        this.txnDate = txnDate;
    }

    public UpiExpressAccountEntity() {

    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Double getLimitAmount() {
        return limitAmount;
    }

    public void setLimitAmount(Double limitAmount) {
        this.limitAmount = limitAmount;
    }

    public String getTxnDate() {
        return txnDate;
    }

    public void setTxnDate(String txnDate) {
        this.txnDate = txnDate;
    }
}