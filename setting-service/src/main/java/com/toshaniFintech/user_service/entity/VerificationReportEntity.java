package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "th_verification_report")
@NoArgsConstructor
public class VerificationReportEntity extends BaseEntity {

    @Column(name = "start_date", nullable = false)
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "txn_date")
    private String txnDate;

    @Column(name = "partner_details", columnDefinition = "TEXT")
    private String partnerDetails;

    @Column(name = "request_id")
    private String requestID;

    @Column(name = "type")
    private String type;

    @Column(name = "status")
    private String status;

    @Column(name = "request_data", columnDefinition = "TEXT")
    private String request;

    @Column(name = "response_data", columnDefinition = "TEXT")
    private String response;

    public VerificationReportEntity(String startDate, String endDate, String txnDate, String partnerDetails, String requestID, String type, String status, String request, String response) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.txnDate = txnDate;
        this.partnerDetails = partnerDetails;
        this.requestID = requestID;
        this.type = type;
        this.status = status;
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

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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