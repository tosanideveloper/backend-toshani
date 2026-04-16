package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "th_aeps2_report")
@Data
public class Aeps2ReportEntity extends BaseEntity {

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

    @Column(name = "merchant_code")
    private String merchantCode;

    @Column(name = "api_txn_id")
    private String apiTxnID;

    public Aeps2ReportEntity(String startDate, String endDate, String txnDate,
                             String partnerDetails, String txnID, String orderID,
                             String merchantCode, String apiTxnID) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.txnDate = txnDate;
        this.partnerDetails = partnerDetails;
        this.txnID = txnID;
        this.orderID = orderID;
        this.merchantCode = merchantCode;
        this.apiTxnID = apiTxnID;
    }

    public Aeps2ReportEntity() {

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

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public String getApiTxnID() {
        return apiTxnID;
    }

    public void setApiTxnID(String apiTxnID) {
        this.apiTxnID = apiTxnID;
    }
}