package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "th_modify_report")
@NoArgsConstructor
public class ModifyReportEntity extends BaseEntity {

    @Column(name = "start_date", nullable = false)
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "txn_date")
    private String txnDate;

    @Column(name = "partner_details")
    private String partnerDetails;

    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "txn_id")
    private String txnID;

    @Column(name = "order_id")
    private String orderID;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "ifsc")
    private String ifsc;

    public ModifyReportEntity(String startDate, String endDate, String txnDate, String partnerDetails, String serviceName, String txnID, String orderID, String accountNumber, String ifsc) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.txnDate = txnDate;
        this.partnerDetails = partnerDetails;
        this.serviceName = serviceName;
        this.txnID = txnID;
        this.orderID = orderID;
        this.accountNumber = accountNumber;
        this.ifsc = ifsc;
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

    public String getPartnerDetails() {
        return partnerDetails;
    }

    public void setPartnerDetails(String partnerDetails) {
        this.partnerDetails = partnerDetails;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }
}