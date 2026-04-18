package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "th_matm_report")
@NoArgsConstructor
public class MatmReportEntity extends BaseEntity {

    @Column(name = "start_date", nullable = false)
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "txn_date")
    private String txnDate;

    @Column(name = "partner_details")
    private String partnerDetails;

    @Column(name = "txn_id")
    private String txnID;

    @Column(name = "order_id")
    private String orderID;

    @Column(name = "api_txn_id")
    private String apiTxnID;

    @Column(name = "card_no")
    private String cardNo;

    @Column(name = "card_type")
    private String cardType;

    @Column(name = "txn_type")
    private String txnType;

    @Column(name = "amount")
    private String amount;

    @Column(name = "utr")
    private String utr;

    @Column(name = "comm")
    private String comm;

    @Column(name = "tds")
    private String tds;

    @Column(name = "txn_status")
    private String txnStatus;

    @Column(name = "response_message")
    private String responseMessage;

    public MatmReportEntity(String startDate, String endDate, String txnDate,
                            String partnerDetails, String txnID, String orderID,
                            String apiTxnID, String cardNo,String cardType, String txnType,
                            String amount, String utr, String comm, String tds,
                            String status, String responseMessage) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.txnDate = txnDate;
        this.partnerDetails = partnerDetails;
        this.txnID = txnID;
        this.orderID = orderID;
        this.apiTxnID = apiTxnID;
        this.cardNo = cardNo;
        this.cardType = cardType;
        this.txnType = txnType;
        this.amount = amount;
        this.utr = utr;
        this.comm = comm;
        this.tds = tds;
        this.txnStatus = status;
        this.responseMessage = responseMessage;
    }

    public String getTxnType() {
        return txnType;
    }

    public void setTxnType(String txnType) {
        this.txnType = txnType;
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

    public String getApiTxnID() {
        return apiTxnID;
    }

    public void setApiTxnID(String apiTxnID) {
        this.apiTxnID = apiTxnID;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

     public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getUtr() {
        return utr;
    }

    public void setUtr(String utr) {
        this.utr = utr;
    }

    public String getComm() {
        return comm;
    }

    public void setComm(String comm) {
        this.comm = comm;
    }

    public String getTds() {
        return tds;
    }

    public void setTds(String tds) {
        this.tds = tds;
    }

    public String getTxnStatus() {
        return txnStatus;
    }

    public void setTxnStatus(String status) {
        this.txnStatus = status;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}