package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "th_recharge_report")
@Data
@NoArgsConstructor
public class RechargeReportEntity extends BaseEntity {

    @Column(name = "start_date", nullable = false)
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "sl_no")
    private String slNo;

    @Column(name = "txn_date")
    private String txnDate;

    @Column(name = "partner_details", columnDefinition = "TEXT")
    private String partnerDetails;

    @Column(name = "txn_id")
    private String txnID;

    @Column(name = "rrn")
    private String rrn;

    @Column(name = "order_id")
    private String orderID;

    @Column(name = "type")
    private String type;

    @Column(name = "operator_name")
    private String operator;

    @Column(name = "mobile_number")
    private String number;

    @Column(name = "operator_id")
    private String operatorID;

    @Column(name = "amount")
    private String amount;

    @Column(name = "commission")
    private String commission;

    @Column(name = "tds")
    private String tds;

    @Column(name = "status")
    private String status;

    @Column(name = "api_name")
    private String api;

    @Column(name = "request_data", columnDefinition = "TEXT")
    private String request;

    @Column(name = "response_data", columnDefinition = "TEXT")
    private String response;

    public RechargeReportEntity(String startDate, String endDate, String slNo, String txnDate, String partnerDetails, String txnID,String rrn, String orderID, String type, String operator, String number, String operatorID, String amount, String commission, String tds, String status, String api, String request, String response) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.slNo = slNo;
        this.txnDate = txnDate;
        this.partnerDetails = partnerDetails;
        this.txnID = txnID;
        this.rrn = rrn;
        this.orderID = orderID;
        this.type = type;
        this.operator = operator;
        this.number = number;
        this.operatorID = operatorID;
        this.amount = amount;
        this.commission = commission;
        this.tds = tds;
        this.status = status;
        this.api = api;
        this.request = request;
        this.response = response;
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

    public String getSlNo() {
        return slNo;
    }

    public void setSlNo(String slNo) {
        this.slNo = slNo;
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

    public String getTxnID() {
        return txnID;
    }

    public void setTxnID(String txnID) {
        this.txnID = txnID;
    }

    public String getRrn() {
        return rrn;
    }

    public void setRrn(String rrn) {
        this.rrn = rrn;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getOperatorID() {
        return operatorID;
    }

    public void setOperatorID(String operatorID) {
        this.operatorID = operatorID;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }

    public String getTds() {
        return tds;
    }

    public void setTds(String tds) {
        this.tds = tds;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}