package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "transaction-log-backup-report")
public class TransactionLogBackupReportEntity extends BaseEntity {
    @Column(name = "txn_date")
    private String txnDate;

    @Column(name = "api_user_details")
    private String apiUserDetails;


    @Column(name = "account_Number")
    private String accountNumber;

    @Column(name = "bank_Name")
    private String bankName;

    @Column(name = "utr")
    private String utr;

    @Column(name = "amount")
    private String amount;

    @Column(name = "charges")
    private String charges;

    @Column(name = " gst")
    private String gst;

    @Column(name = "commission")
    private String commission;

    @Column(name = "tds")
    private String tds;

    @Column(name = "api_Name")
    private String apiName;

    @Column(name = "ifsc")
    private String ifsc;

    @Column(name = "txn_ID")
    private String txnId;

    @Column(name = "order_ID")
    private String orderId;

    @Column(name = "txn_type")
    private String txnType;

    @Column(name = "txn_status")
    private String txnStatus;

    public String getTxnDate() {return txnDate;}

    public void setTxnDate(String txnDate) {this.txnDate = txnDate;}

    public String getApiUserDetails() {return apiUserDetails;}

    public void setApiUserDetails(String apiUserDetails) {this.apiUserDetails = apiUserDetails;}

    public String getAccountNumber() {return accountNumber;}

    public void setAccountNumber(String accountNumber) {this.accountNumber = accountNumber;}

    public String getBankName() {return bankName;}

    public void setBankName(String bankName) {this.bankName = bankName;}

    public String getUtr() {return utr;}

    public void setUtr(String utr) {this.utr = utr;}

    public String getAmount() {return amount;}

    public void setAmount(String amount) {this.amount = amount;}

    public String getCharges() {return charges;}

    public void setCharges(String charges) {this.charges = charges;}

    public String getGst() {return gst;}

    public void setGst(String gst) {this.gst = gst;}

    public String getCommission() {return commission;}

    public void setCommission(String commission) {this.commission = commission;}

    public String getTds() {return tds;}

    public void setTds(String tds) {this.tds = tds;}

    public String getApiName() {return apiName;}

    public void setApiName(String apiName) {this.apiName = apiName;}

    public String getIfsc() {return ifsc;}

    public void setIfsc(String ifsc) {this.ifsc = ifsc;}

    public String getTxnId() {return txnId;}

    public void setTxnId(String txnId) {this.txnId = txnId;}

    public String getOrderId() {return orderId;}

    public void setOrderId(String orderId) {this.orderId = orderId;}

    public String getTxnType() {return txnType;}

    public void setTxnType(String txnType) {this.txnType = txnType;}

    public String getTxnStatus() {return txnStatus;}

    public void setTxnStatus(String txnStatus) {this.txnStatus = txnStatus;}
}
