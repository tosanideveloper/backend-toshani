package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "th_aeps1_report")
public class Aeps1ReportEntity extends BaseEntity {

    @Column(name = "txn_date")
    private String txnDate;

    @Column(name = "txn_ID")
    private String txnID;

    @Column(name = "order_ID")
    private String orderID;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "aadhaar_No")
    private String aadhaarNo;

    @Column(name = "txn_type")
    private String txnType;

    @Column(name = "amount")
    private String amount;

    @Column(name = "RRN")
    private String rrn;

    public Aeps1ReportEntity(String startDate, String endDate, String txnDate, String txnID, String orderID, String bankName, String aadhaarNo, String txnType, String amount, String rrn) {
        this.txnDate = txnDate;
        this.txnID = txnID;
        this.orderID = orderID;
        this.bankName = bankName;
        this.aadhaarNo = aadhaarNo;
        this.txnType = txnType;
        this.amount = amount;
        this.rrn = rrn;
    }

    public Aeps1ReportEntity() {

    }

    public String getTxnDate() {
        return txnDate;
    }

    public void setTxnDate(String txnDate) {
        this.txnDate = txnDate;
    }

    public String getTxnID() {
        return txnID;
    }

    public void setTxnID(String txnID) {
        this.txnID = txnID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAadhaarNo() {
        return aadhaarNo;
    }

    public void setAadhaarNo(String aadhaarNo) {
        this.aadhaarNo = aadhaarNo;
    }

    public String getTxnType() {
        return txnType;
    }

    public void setTxnType(String txnType) {
        this.txnType = txnType;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getRrn() {
        return rrn;
    }

    public void setRrn(String rrn) {
        this.rrn = rrn;
    }
}
