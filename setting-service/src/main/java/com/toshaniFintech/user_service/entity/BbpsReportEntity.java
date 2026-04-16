package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "th_bbps_report")
@Data
@NoArgsConstructor
public class BbpsReportEntity extends BaseEntity {

    @Column(name = "start_date", nullable = false)
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "txn_date")
    private String txnDate;

    @Column(name = "partner_details", columnDefinition = "TEXT")
    private String partnerDetails;

    @Column(name = "txn_id")
    private String txnID;

    @Column(name = "order_id")
    private String orderID;

    @Column(name = "api_request_id")
    private String apiRequestID;

    @Column(name = "type")
    private String type;

    @Column(name = "biller_name")
    private String billerName;

    @Column(name = "amount")
    private String amount;

    @Column(name = "charges")
    private String charges;

    @Column(name = "gst")
    private String gst;

    @Column(name = "commission")
    private String commission;

    @Column(name = "tds")
    private String tds;

    @Column(name = "api_status")
    private String apiStatus;

    @Column(name = "api_name")
    private String apiName;

    @Column(name = "status")
    private String status;

    @Column(name = "request_data", columnDefinition = "TEXT")
    private String request;

    @Column(name = "response_data", columnDefinition = "TEXT")
    private String response;

    @Column(name = "callback_data", columnDefinition = "TEXT")
    private String callback;

    @Column(name = "xml_request", columnDefinition = "TEXT")
    private String xmlRequest;

    @Column(name = "xml_response", columnDefinition = "TEXT")
    private String xmlResponse;

    public BbpsReportEntity(String startDate, String endDate, String txnDate, String partnerDetails, String txnID, String orderID, String apiRequestID, String type, String billerName, String amount, String charges, String gst, String commission, String tds, String apiStatus, String apiName, String status, String request, String response, String callback, String xmlRequest, String xmlResponse) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.txnDate = txnDate;
        this.partnerDetails = partnerDetails;
        this.txnID = txnID;
        this.orderID = orderID;
        this.apiRequestID = apiRequestID;
        this.type = type;
        this.billerName = billerName;
        this.amount = amount;
        this.charges = charges;
        this.gst = gst;
        this.commission = commission;
        this.tds = tds;
        this.apiStatus = apiStatus;
        this.apiName = apiName;
        this.status = status;
        this.request = request;
        this.response = response;
        this.callback = callback;
        this.xmlRequest = xmlRequest;
        this.xmlResponse = xmlResponse;
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

    public String getApiRequestID() {
        return apiRequestID;
    }

    public void setApiRequestID(String apiRequestID) {
        this.apiRequestID = apiRequestID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBillerName() {
        return billerName;
    }

    public void setBillerName(String billerName) {
        this.billerName = billerName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCharges() {
        return charges;
    }

    public void setCharges(String charges) {
        this.charges = charges;
    }

    public String getGst() {
        return gst;
    }

    public void setGst(String gst) {
        this.gst = gst;
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

    public String getApiStatus() {
        return apiStatus;
    }

    public void setApiStatus(String apiStatus) {
        this.apiStatus = apiStatus;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
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

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    public String getXmlRequest() {
        return xmlRequest;
    }

    public void setXmlRequest(String xmlRequest) {
        this.xmlRequest = xmlRequest;
    }

    public String getXmlResponse() {
        return xmlResponse;
    }

    public void setXmlResponse(String xmlResponse) {
        this.xmlResponse = xmlResponse;
    }
}